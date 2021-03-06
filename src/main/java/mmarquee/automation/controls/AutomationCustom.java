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
 * Wrapper for the Custom ControlId, which is usually a container.
 * @author Mark Humphreys
 * Date 08/03/2016.
 */
public class AutomationCustom extends AutomationContainer implements Valueable {

    /**
     * The value pattern.
     */
    private Value valuePattern;

    /**
     * Constructor for the AutomationCustom element.
     *
     * @param builder The builder
     */
    public AutomationCustom(final ElementBuilder builder) {
        super(builder);
        this.valuePattern = builder.getValue();
    }

    /**
     * Gets the value text associated with this element.
     *
     * @return The value of the item.
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Failed to find pattern.
     */
    public String getValue()
            throws AutomationException, PatternNotFoundException {
        if (this.valuePattern == null) {
            this.valuePattern = this.getValuePattern();
        }

        return this.valuePattern.value();
    }
}
