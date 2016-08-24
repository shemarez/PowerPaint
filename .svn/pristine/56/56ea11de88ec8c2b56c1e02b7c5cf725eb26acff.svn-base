package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import gui.DrawingPanel;
import tools.PencilListener;
/**
 * Determines action for when "Pencil" 
 * button is clicked, in this case, calls
 * PencilListener().
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public class PencilAction extends AbstractAction {
    
    /**
     * Generate serial UID.
     */
    private static final long serialVersionUID = -2359414782512470419L;
    /** Stores main drawing area. */
    private final DrawingPanel myDrawingArea;
    /** Constructor, takes in drawing area. 
     * @param theDrawingArea a drawing panel
     */
    public PencilAction(final DrawingPanel theDrawingArea) {
        super("Pencil");
        this.myDrawingArea = theDrawingArea;
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
      
        myDrawingArea.setMyCurrentTool(new PencilListener());
        
        
    }
    

}
