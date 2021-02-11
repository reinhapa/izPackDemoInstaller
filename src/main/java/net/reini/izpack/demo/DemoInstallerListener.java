/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019-2021 Patrick Reinhart
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

import java.util.List;
import java.util.logging.Logger;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.data.Pack;
import com.izforge.izpack.api.event.AbstractInstallerListener;
import com.izforge.izpack.api.event.ProgressListener;
import com.izforge.izpack.util.Housekeeper;

/**
 * @author Patrick Reinhart
 */
public class DemoInstallerListener extends AbstractInstallerListener {
  private final Logger log;
  private final InstallData installData;

  public DemoInstallerListener(Housekeeper housekeeper, InstallData installData) {
    this.installData = installData;
    installData.setVariable("user.ident", "gugus");
    log = Logger.getLogger(getClass().getName());
    log.warning(String.format("DemoInstallerListener(%s, %s)", housekeeper.toString(),
        installData.toString()));
  }

  @Override
  public void beforePacks(List<Pack> packs) {
    log.info("beforePacks: variable " + installData.getVariable("variable"));
    log.info("beforePacks: data.dir " + installData.getVariable("data.dir"));
    installData.setVariable("variable", "beforePacks");
  }

  @Override
  public void afterPacks(List<Pack> packs, ProgressListener listener) {
    log.info("afterPacks: variable " + installData.getVariable("variable"));
    log.info("afterPacks: data.dir " + installData.getVariable("data.dir"));
  }
}
