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
import mmarquee.automation.pattern.ExpandCollapse;
import mmarquee.automation.pattern.PatternNotFoundException;
import mmarquee.automation.pattern.SelectionItem;

/**
 * Wrapper for the TreeViewItem element.
 *
 * @author Mark Humphreys
 * Date 20/02/2016
 */
public final class AutomationTreeViewItem
        extends AutomationBase
        implements Selectable, Clickable, Expandable {

    /** The expand/collpase pattern. */
    private ExpandCollapse expandCollapsePattern;

    /** The selectionitem pattern. */
    private SelectionItem selectItemPattern;

    /**
     * Construct the AutomationTreeViewItem.
     * @param builder The element.
     */
    public AutomationTreeViewItem(final ElementBuilder builder) {
        super(builder);

        this.selectItemPattern = builder.getSelectItem();
        this.expandCollapsePattern = builder.getCollapse();
    }

    /**
     * Select the item.
     * @throws AutomationException Automation library issue.
     * @throws PatternNotFoundException Pattern not found.
     */
    public void select()
            throws AutomationException, PatternNotFoundException {
        if (this.selectItemPattern == null) {
            this.selectItemPattern = this.getSelectItemPattern();
        }
        if (this.selectItemPattern != null) {
        	this.selectItemPattern.select();
        } else {
            throw new PatternNotFoundException("Select Pattern was not found");
        }
    }

    /**
     * Is this item selected.
     * @return True if selected.
     * @throws AutomationException Automation library issue.
     * @throws PatternNotFoundException Pattern not found.
     */
    public boolean isSelected()
            throws AutomationException, PatternNotFoundException {
        if (this.selectItemPattern == null) {
            this.selectItemPattern = this.getSelectItemPattern();
        }

        if (this.selectItemPattern != null) {
        	return this.selectItemPattern.isSelected();
        }
        throw new PatternNotFoundException("Select state cannot be determined");
    }

    /**
     * Click the item.
     * @throws AutomationException Automation library issue.
     * @throws PatternNotFoundException Pattern not found.
     */
    public void click()
            throws AutomationException, PatternNotFoundException {
        super.invoke();
    }

    /**
     * Is the control expanded.
     * @return True if expanded.
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Expected pattern not found.
     */
    public boolean isExpanded()
            throws AutomationException, PatternNotFoundException {
        if (this.expandCollapsePattern == null) {
                this.expandCollapsePattern = this.getExpandCollapsePattern();
        }

        if (this.expandCollapsePattern != null) {
            return expandCollapsePattern.isExpanded();
        }

        throw new PatternNotFoundException("Collapse state cannot be determined");
    }

    /**
     * Collapses the element.
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Expected pattern not found.
     */
    public void collapse()
            throws AutomationException, PatternNotFoundException {
        if (this.expandCollapsePattern == null) {
                this.expandCollapsePattern = this.getExpandCollapsePattern();
        }

        if (this.expandCollapsePattern != null) {
                this.expandCollapsePattern.collapse();
        } else {
        	throw new PatternNotFoundException("Cannot collapse");
        }
    }

    /**
     * Expands the element.
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Expected pattern not found.
     */
    public void expand()
            throws AutomationException, PatternNotFoundException {
        if (this.expandCollapsePattern == null) {
                this.expandCollapsePattern = this.getExpandCollapsePattern();
        }

        if (this.expandCollapsePattern != null) {
                this.expandCollapsePattern.expand();
        } else {
        	throw new PatternNotFoundException("Cannot expand");
        }
    }
}
