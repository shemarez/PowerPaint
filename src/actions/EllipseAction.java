/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import gui.DrawingPanel;
import tools.EllipseListener;
/**
 * Determines action for when "Ellipse" 
 * button is clicked, in this case, calls
 * EllipseListener().
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */

public class EllipseAction extends AbstractAction {
    /**
     * Generate serial UID.
     */
    private static final long serialVersionUID = -2466218894621322428L;
    /** Stores main drawing area. */
    private final DrawingPanel myDrawingArea;
    /** Constructor, takes in drawing area. 
     * @param theDrawingArea a drawing panel
     */
    public EllipseAction(final DrawingPanel theDrawingArea) {
        super("Ellipse");
        this.myDrawingArea = theDrawingArea;
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
      
        myDrawingArea.setMyCurrentTool(new EllipseListener());        
        
    }

}
