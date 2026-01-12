<?xml version="1.0"?>
<!--

    The MIT License (MIT)

    Copyright (c) 2019-2026 Patrick Reinhart

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.

-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" standalone="no" />

  <xsl:template match="/">
    <xsl:apply-templates select="/AutomatedInstallation" />
  </xsl:template>

  <xsl:template match="AutomatedInstallation">
    <AutomatedInstallation langpack="{@langpack}">
      <xsl:for-each select="*[not(name()='CH.obj.installer.common.panel.BisonShortcutPanel')]">
        <xsl:call-template name="panel" />
      </xsl:for-each>
    </AutomatedInstallation>
  </xsl:template>

  <xsl:template name="panel">
    <xsl:param name="nodeName">
      <xsl:choose>
        <xsl:when test="name()='CH.obj.installer.common.panel.InstallationTypePanel'">CH.obj.installer.server.panel.InstallationTypePanel</xsl:when>
        <xsl:when test="name()='CH.obj.installer.common.panel.FinishPanel'">CH.obj.installer.server.panel.ServerFinishPanel</xsl:when>
        <xsl:when test="name()='com.izforge.izpack.panels.UserInputPanel'">com.izforge.izpack.panels.userinput.UserInputPanel</xsl:when>
        <xsl:when test="name()='com.izforge.izpack.panels.LicencePanel'">com.izforge.izpack.panels.licence.LicencePanel</xsl:when>
        <xsl:when test="name()='com.izforge.izpack.panels.PacksPanel'">com.izforge.izpack.panels.packs.PacksPanel</xsl:when>
        <xsl:when test="name()='com.izforge.izpack.panels.SummaryPanel'">com.izforge.izpack.panels.summary.SummaryPanel</xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="name()" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:param>
    <xsl:param name="idAttribute">
      <xsl:choose>
        <xsl:when test="name()='CH.obj.installer.server.panel.PreReleaseFinishPanel'">server.prerelease.finish.panel.id</xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="./@id" />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:param>
    <xsl:element name="{$nodeName}">
      <xsl:attribute name="id"><xsl:value-of select="$idAttribute" /></xsl:attribute>
      <xsl:for-each select="@*[not(name()='id')]">
        <xsl:attribute name="{name()}">
        <xsl:value-of select="." />
        </xsl:attribute>
      </xsl:for-each>
      <xsl:for-each select="userInput/*">
        <xsl:copy-of select="." />
      </xsl:for-each>
      <xsl:for-each select="pack">
        <xsl:param name="packName">
          <xsl:choose>
            <xsl:when test="@name='core'">Core</xsl:when>
            <xsl:when test="@name='properties'">Properties</xsl:when>
            <xsl:when test="@name='clients'">Clients</xsl:when>
            <xsl:when test="@name='data'">Data</xsl:when>
            <xsl:when test="@name='utils'">Utils</xsl:when>
            <xsl:when test="@name='wrapper'">Wrapper</xsl:when>
            <xsl:when test="@name='docs'">Docs</xsl:when>
            <xsl:when test="@name='log' and @index=4">ServerLog</xsl:when>
            <xsl:when test="@name='log' and @index=8">InstallerLog</xsl:when>
            <xsl:otherwise>
              <xsl:value-of select="@name" />
            </xsl:otherwise>
          </xsl:choose>
        </xsl:param>
        <xsl:element name="pack">
        <xsl:attribute name="index">
          <xsl:value-of select="@index" />
        </xsl:attribute>
        <xsl:attribute name="name">
          <xsl:value-of select="$packName" />
        </xsl:attribute>
        <xsl:attribute name="selected">
          <xsl:value-of select="@selected" />
        </xsl:attribute>
        </xsl:element>
      </xsl:for-each>
      <xsl:for-each select="*[not(name()='userInput' or name()='pack')]">
        <xsl:copy-of select="." />
      </xsl:for-each>
    </xsl:element>
  </xsl:template>

</xsl:stylesheet>
