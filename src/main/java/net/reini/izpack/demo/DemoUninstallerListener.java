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
