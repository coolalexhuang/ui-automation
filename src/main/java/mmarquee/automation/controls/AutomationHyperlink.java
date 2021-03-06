/*
 * Copyright 2016-17 inpwtepydjuf@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mmarquee.automation.controls;

import mmarquee.automation.AutomationException;
import mmarquee.automation.pattern.PatternNotFoundException;

/**
 * Wrapper for the Hyperlink element.
 * @author Mark Humphreys
 * Date 03/02/2016.
 */
public final class AutomationHyperlink extends AutomationBase implements Clickable {

      /**
       * Constructor for the AutomationHyperlink.
     *
     * @param builder The builder
     */
    public AutomationHyperlink(final ElementBuilder builder) {
        super(builder);
    }

    /**
     * Fires the click event associated with this element.
     * @throws AutomationException Something has gone wrong
     * @throws PatternNotFoundException Did not find the pattern
     **/
    public void click() throws AutomationException, PatternNotFoundException {
        super.invoke();
    }
}

