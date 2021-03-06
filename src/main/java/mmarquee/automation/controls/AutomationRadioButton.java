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
import mmarquee.automation.pattern.SelectionItem;

/**
 * Wrapper for the RadioButton element.
 *
 * @author Mark Humphreys
 * Date 31/01/2016.
 */
public final class AutomationRadioButton extends AutomationBase implements Selectable {

    /**
     * The selection item pattern.
     */
    private SelectionItem selectItemPattern;

    /**
     * Construct the AutomationRadioButton.
     *
     * @param builder The builder.
     */
    public AutomationRadioButton(final ElementBuilder builder) {
        super(builder);
        selectItemPattern = builder.getSelectItem();
    }

    /**
     * Selects this element.
     *
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Failed to find pattern.
     */
    public void select()
            throws AutomationException, PatternNotFoundException {
        if (this.selectItemPattern == null) {
            selectItemPattern = this.getSelectItemPattern();
        }

        this.selectItemPattern.select();
    }

    /**
     * Gets the selection state.
     *
     * @return The selection state.
     * @throws AutomationException Error in the automation library.
     * @throws PatternNotFoundException Failed to find pattern.
     */
    public boolean isSelected()
            throws AutomationException, PatternNotFoundException {
        if (this.selectItemPattern == null) {
            selectItemPattern = this.getSelectItemPattern();
        }

        return this.selectItemPattern.isSelected();
    }
}
