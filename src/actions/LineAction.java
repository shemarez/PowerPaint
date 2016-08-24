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
import tools.LineListener;

/**
 * Determines action for when "Line" 
 * button is clicked, in this case, calls
 * LineListener().
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public class LineAction extends AbstractAction {
    /**
     * Generate serial UID.
     */
    private static final long serialVersionUID = -6337781717090535746L;
    /** Stores main drawing area. */

    private final DrawingPanel myDrawingArea;
    
    /** Constructor, takes in drawing area. 
     * @param theDrawingArea a drawing panel
     */
    public LineAction(final DrawingPanel theDrawingArea) {
        super("Line");
        this.myDrawingArea = theDrawingArea;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawingArea.setMyCurrentTool(new LineListener());
                
        
    }

}
