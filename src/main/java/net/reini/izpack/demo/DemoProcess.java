
package net.reini.izpack.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.izforge.izpack.panels.process.AbstractUIProcessHandler;

/**
 * @author Patrick Reinhart
 */
public class DemoProcess {

  public boolean run(AbstractUIProcessHandler handler, String[] arguments) {
    Logger log = Logger.getLogger(getClass().getName());
    List<String> argumentList = Arrays.asList(arguments);
    log.warning(String.format("DemoProcess.run(%s, %s) with 30 second delay", handler.toString(), argumentList));
    try {
      TimeUnit.SECONDS.sleep(30);
    } catch (InterruptedException e) {
      log.log(Level.SEVERE, "Unexpected interruption", e);
    }
    return !argumentList.contains("fail");
  }
}
