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
import mmarquee.automation.pattern.Value;

/**
 * Wrapper for the TextBox element.
 *
 * @author Mark Humphreys
 * Date 01/02/2016.
 */
public final class AutomationTextBox
        extends AutomationBase
        implements Valueable {

    /**
     * The value pattern.
     */
    private Value valuePattern;

    /**
     * Construct the AutomationTextBox.
     *
     * @param builder The builder.
     */
    public AutomationTextBox(final ElementBuilder builder) {
        super(builder);
        this.valuePattern = builder.getValue();
    }

    /**
     * Gets the text associated with this element.
     *
     * @return The current text.
     * @throws AutomationException Automation library error.
     * @throws PatternNotFoundException Expected pattern not found.
     */
    public String getValue()
            throws PatternNotFoundException, AutomationException {
        if (this.valuePattern == null) {
            try {
                this.valuePattern = this.getValuePattern();
            } catch (NullPointerException ex) {
                logger.info("No value pattern available");
            }
        }

        try {
            return valuePattern.value();
        } catch (NullPointerException ex) {
            return "<Empty>";
        }
    }
}
