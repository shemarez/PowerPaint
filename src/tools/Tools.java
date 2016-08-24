/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
/**
 * Interface, extended in AbstractTools. 
 * Holds all methods needed for all tools.
 * @author Shema Rezanejad
 * @version 1
 */

public interface  Tools {
    /** Gets description of each tool.
     * @return a String of the class name
     */
    String getDescription();
    /** Draws the shape when mouse pressed. 
     * 
     * @param theStartPoint starting point
     * @param theEndPoint ending point
     * @return a shape
     */
    Shape drawShapes(Point theStartPoint, Point theEndPoint);
    /** Moves the shape when mouse dragged. 
     * 
     * @param theStartPoint starting point
     * @param theEndPoint ending point
     * @return a shape
     */
    Shape moveShape(final Point theStartPoint, final Point theEndPoint);
    /**
     * Gets completed shape.
     * @return a shape
     */
    Shape getShape();
    /**
     * Moves only like a square or circle.
     * @param theStartPoint starting point
     * @param theEndPoint ending point
     * @return a shape
     */
    Shape moveOnlySquare(final Point theStartPoint, final Point theEndPoint);
    /**
     * Sets the current color to the shape.
     * @param theColor current color.
     */
    void setColor(final Color theColor);
    /**
     * Get the color.
     * @return the color.
     */
    Color getColor();

}
