
package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.data.PanelActionConfiguration;
import com.izforge.izpack.api.handler.AbstractUIHandler;
import com.izforge.izpack.data.PanelAction;
import com.izforge.izpack.util.Librarian;

/**
 * @author Patrick Reinhart
 */
public class DemoAction implements PanelAction {

  private final Logger log;

  public DemoAction(Librarian librarian) {
    log = Logger.getLogger(getClass().getName());
    log.warning(String.format("DemoAction(%s, %s)", log.toString(), librarian.toString()));
  }

  @Override
  public void initialize(PanelActionConfiguration configuration) {
    log.warning("Demo action initialze");
  }

  @Override
  public void executeAction(InstallData adata, AbstractUIHandler handler) {
    log.warning("Demo action execute");
  }

}
