/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019-2020 Patrick Reinhart
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
