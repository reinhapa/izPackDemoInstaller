/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019-2026 Patrick Reinhart
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package izPackDemoInstaller;

import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class TransformerTest {
  SAXTransformerFactory transformerFactory;
  SAXParserFactory parserFactory;

  @BeforeEach
  void prepare() throws TransformerConfigurationException, SAXException, ParserConfigurationException {
    transformerFactory = (SAXTransformerFactory)TransformerFactory.newInstance();
    transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
    transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

    parserFactory = SAXParserFactory.newInstance();
    parserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
  }

  @Test
  void xsdTransform1() throws TransformerException {
    Transformer transformer = transformerFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("autoinstall.xsl")));
    StringWriter sw = new StringWriter();

    transformer.transform(new StreamSource(getClass().getResourceAsStream("old_autoinstall.xml")), new StreamResult(sw));

  }
}
