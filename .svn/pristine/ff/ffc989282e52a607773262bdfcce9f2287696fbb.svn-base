/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
/**
 * Creates a custom color Icon for the color tab in 
 * menuBar. Updates when color is changed.
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public class ColorItemIcon implements Icon {
    /** UW color number 1. */
    private static final int UW_COLOR1 = 51;
    
    /** UW color number 2. */
    private static final int UW_COLOR2 = 111;
    /** width of icon. **/
    private static final int WIDTH = 20;
    
    /** height of icon. **/
    private static final int HEIGHT = 20;
    
    /** Stores the current Color. **/
    private Color myColor;
    
    /** Default purple color. **/
    
    private final Color myDefaultColor;
    
    /** Constructor, initializes the default color. */
    
    public ColorItemIcon() {
        myDefaultColor = new Color(UW_COLOR1, 0, UW_COLOR2);
    }
    @Override
    public int getIconHeight() {
        return HEIGHT;
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }
    /** Setting the current color.
     * @param theCurrentColor current color chosen
     */
    public void setColor(final Color theCurrentColor) {
        this.myColor = theCurrentColor;
    }
    @Override
    public void paintIcon(final Component theC, final Graphics theG, 
                          final int theX, final int theY) {
        final Graphics2D g2d = (Graphics2D) theG.create();
        g2d.setColor(myDefaultColor);
        g2d.drawRect(theX, theY, WIDTH, HEIGHT);
        g2d.setColor(myColor);
        g2d.fillRect(theX, theY, WIDTH, HEIGHT);
       
        
    }
    /** Getting the current Color. 
     * 
     * @return myColor
     */
    public Color getColor() {
        return myColor;
    }

}
