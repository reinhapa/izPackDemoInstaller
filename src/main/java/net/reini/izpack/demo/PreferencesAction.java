/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019-2023 Patrick Reinhart
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
package net.reini.izpack.demo;

import java.util.Set;
import java.util.TreeSet;
import java.util.prefs.Preferences;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.data.PanelActionConfiguration;
import com.izforge.izpack.api.handler.AbstractUIHandler;
import com.izforge.izpack.data.PanelAction;

public class PreferencesAction implements PanelAction {
  private final Set<String> variableNames = new TreeSet<>();

  private boolean store;
  private Preferences prefs;


  @Override
  public final void initialize(PanelActionConfiguration configuration) {
    store = Boolean.parseBoolean(configuration.getProperty("store", "false"));
    final Preferences rootPrefs;
    if ("system".equalsIgnoreCase(configuration.getProperty("location", "user"))) {
      rootPrefs = Preferences.systemRoot();
    } else {
      rootPrefs = Preferences.userRoot();
    }
    prefs = rootPrefs.node("com.izforge.izpack.installer.variables");
    for (String variableName : configuration.getProperty("variables", "").split("[ ]")) {
      variableName = variableName.trim();
      if (!variableName.isEmpty()) {
        variableNames.add(variableName);
      }
    }
  }

  @Override
  public final void executeAction(InstallData data, AbstractUIHandler handler) {
    if (prefs != null && !variableNames.isEmpty()) {
      for (String variableName : variableNames) {
        if (store) {
          String value = data.getVariable(variableName);
          if (value == null) {
            prefs.remove(variableName);
          } else {
            prefs.put(variableName, value);
          }
        } else {
          String value = prefs.get(variableName, null);
          if (value != null) {
            data.setVariable(variableName, value);
          }
        }
      }
    }
  }
}
