/**
 * File Name: DemoProcessor.java
 * 
 * Copyright (c) 2019 BISON Schweiz AG, All Rights Reserved.
 */

package net.reini.izpack.demo;

import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.panels.userinput.processor.Processor;
import com.izforge.izpack.panels.userinput.processorclient.ProcessingClient;

/**
 * @author Patrick Reinhart
 */
public class DemoProcessor implements Processor {
  private Logger log = Logger.getLogger(getClass().getName());

  public DemoProcessor(InstallData installData) {
    log.warning(String.format("DemoProcessor(%s)", installData.toString()));
  }

  @Override
  public String process(ProcessingClient client) {
    String text = client.getText();
    log.warning("process: " + text);
    return text;
  }

}
