
package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.data.PanelActionConfiguration;
import com.izforge.izpack.api.handler.AbstractUIHandler;
import com.izforge.izpack.data.PanelAction;

/**
 * @author Patrick Reinhart
 */
public class DemoPreActivateAction implements PanelAction {
  private final Logger log;

  public DemoPreActivateAction() {
    log = Logger.getLogger(getClass().getName());
  }

  @Override
  public void initialize(PanelActionConfiguration configuration) {
    log.warning("Demo pre activate action initialze");
  }

  @Override
  public void executeAction(InstallData adata, AbstractUIHandler handler) {
    log.warning("Demo pre activate action execute");
  }
}
