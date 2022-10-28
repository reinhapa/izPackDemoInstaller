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
