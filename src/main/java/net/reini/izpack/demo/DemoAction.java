
package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.data.PanelActionConfiguration;
import com.izforge.izpack.api.handler.AbstractUIHandler;
import com.izforge.izpack.data.PanelAction;
import com.izforge.izpack.gui.log.Log;
import com.izforge.izpack.util.Librarian;

/**
 * @author Patrick Reinhart
 */
public class DemoAction implements PanelAction {

  private final Log log;

  public DemoAction(Log log, Librarian librarian) {
    Logger.getLogger(getClass().getName()).warning(String.format("DemoAction(%s, %s)", log.toString(), librarian.toString()));
    this.log = log;
  }

  @Override
  public void executeAction(InstallData adata, AbstractUIHandler handler) {
    log.addCustomMessage("Demo action execute", new String[0]);
  }

  @Override
  public void initialize(PanelActionConfiguration configuration) {
    log.addCustomMessage("Demo action initialze", new String[0]);
  }

}
