/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019-2025 Patrick Reinhart
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
import com.izforge.izpack.api.installer.DataValidator;

/**
 * @author Patrick Reinhart
 */
public class DemoDataValidator implements DataValidator {

  public DemoDataValidator() {
    Logger.getLogger(getClass().getName()).warning("DemoDataValidator()");
  }

  @Override
  public Status validateData(InstallData installData) {
    if ("peng".equals(installData.getVariable("user.name"))) {
      return Status.ERROR;
    }
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
