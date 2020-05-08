
package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.installer.DataValidator;

/**
 * @author Patrick Reinhart
 */
public class DemoDataValidator implements DataValidator {

  public DemoDataValidator() {
    Logger log = Logger.getLogger(getClass().getName());
    log.warning("DemoDataValidator()");
  }

  @Override
  public Status validateData(InstallData installData) {
    return Status.OK;
  }

  @Override
  public String getErrorMessageId() {
    return null;
  }

  @Override
  public String getWarningMessageId() {
    return null;
  }

  @Override
  public boolean getDefaultAnswer() {
    return false;
  }

}
