
package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.event.AbstractUninstallerListener;
import com.izforge.izpack.util.Housekeeper;

/**
 * @author Patrick Reinhart
 */
public class DemoUninstallerListener extends AbstractUninstallerListener {

  public DemoUninstallerListener(Housekeeper housekeeper, InstallData installData) {
    Logger log = Logger.getLogger(getClass().getName());
    log.warning(String.format("Constructor arguments: %s, %s", housekeeper.toString(), installData.toString()));
    log.warning(String.format("Install dir: %s", installData.getVariable("INSTALL_PATH")));
  }
}
