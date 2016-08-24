/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package tools;

import java.awt.Color;
/**
 * Abstract tool, implements Tools. Sets and
 * gets the current color. 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public  abstract class AbstractTools implements Tools {
    /** Description. */
    private final String myDescription;
    /** Current color. */
    private Color myColor;
    /** Constructor. 
     * Initializes description.
     * @param theDescription the class name
     */
    public AbstractTools(final String theDescription) {
        this.myDescription = theDescription;
    }
    /**
     * sets the current color.
     * @param theColor current color
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    /**
     * @return the current color
     */
    public Color getColor() {
        return myColor;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return myDescription;
    }


}
