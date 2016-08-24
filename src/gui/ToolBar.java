/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */

package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;


/**
 * This class creates a toolbar that is 
 * added into the main frame. Creates buttons, adds
 * to group. 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public final class ToolBar extends JToolBar {
    /** Generated serial version UID.     */
    private static final long serialVersionUID = -6297787221312734786L;
    
    /** Button group for tools. */
    private final ButtonGroup myGroup;
    
    /**
     * Constructor, initializes array lists.
     * Creates ToggleButtons in enhanced for loop.
     */
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }

    /**
     * Creates the ToolBar. Adds icons to each
     * button. Adds each button to a button group.
     * adds each button to the toolbar.
     * @return a JToggleButton
     * @param theAction the current action
     */
    public JToggleButton createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        final ImageIcon icon = new ImageIcon("images/" + toggleButton.getText().toLowerCase() 
                                             + "_bw.gif");
        toggleButton.setIcon(icon);
        myGroup.add(toggleButton);
        myGroup.clearSelection();
        add(toggleButton);
        return toggleButton;
        
    }

 

}
