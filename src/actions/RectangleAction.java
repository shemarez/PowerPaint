package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import gui.DrawingPanel;
import tools.RectangleListener;

/**
 * Determines action for when "Rectangle" 
 * button is clicked, in this case, calls
 * RectangleListener().
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public class RectangleAction extends AbstractAction {
    /**
     * Generate serial UID.
     */
    private static final long serialVersionUID = 4738896753002784204L;
    /** Stores main drawing area. */
    private final DrawingPanel myDrawingArea;
    /** Constructor, takes in drawing area. 
     * @param theDrawingArea a drawing panel
     */
    public RectangleAction(final DrawingPanel theDrawingArea) {
        super("Rectangle");
        this.myDrawingArea = theDrawingArea;
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
      
        myDrawingArea.setMyCurrentTool(new RectangleListener());
        
    }

}
