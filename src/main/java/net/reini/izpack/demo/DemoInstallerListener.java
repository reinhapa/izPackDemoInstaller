
package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.event.AbstractInstallerListener;
import com.izforge.izpack.util.Housekeeper;

/**
 * @author Patrick Reinhart
 */
public class DemoInstallerListener extends AbstractInstallerListener {

  public DemoInstallerListener(Housekeeper housekeeper, InstallData installData) {
    installData.setVariable("user.ident", "gugus");
    Logger log = Logger.getLogger(getClass().getName());
    log.warning(String.format("DemoInstallerListener(%s, %s)", housekeeper.toString(), installData.toString()));
  }
}
