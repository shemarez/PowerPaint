/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package gui;

import java.awt.Color;
import java.awt.Shape;

import javax.swing.JPanel;
/**
 * Custom class that stores the color, width, and shape
 * of each current shape. The purpose of this is to 
 * be able to store all shapes as an arraylist, so
 * each shape has its own color, and stroke. 
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public class MyShape extends JPanel {
    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = -348201934948035474L;
    /** Stores current stroke width. */
    private int myStrokeWidth;
    /** Stores current color. */
    private Color myColor;
    /** Stores current shape. */
    private Shape myCurrentShape;
    /**
     * Constructor. Takes in updated values of parameters.
     * @param theCurrentShape current shape
     * @param theColor current color
     * @param theStrokeWidth current width
     */
    public MyShape(final Shape theCurrentShape,
                   final Color theColor, final int theStrokeWidth) {
        super();
        this.myCurrentShape = theCurrentShape;
        this.myColor = theColor;
        this.myStrokeWidth = theStrokeWidth;
    }
    /** Sets current shape.
     * 
     * @param theCurrentShape the updated shape
     */
    public void setCurrentShape(final Shape theCurrentShape) {
        this.myCurrentShape = theCurrentShape;
    }
    /** Sets current color.
     * 
     * @param theColor updated color
     */
    public void setCurrentColor(final Color theColor) {
        this.myColor = theColor;
    }
    /**
     * Sets current thickness.
     * @param theThickness updated thickness
     */
    public void setCurrentThickness(final int theThickness) {
        this.myStrokeWidth = theThickness;
    }
    /**
     * Gets current shape.
     * @return current shape
     */
    public Shape getShape() {
        return myCurrentShape;
    }
    /**
     * Gets current color. 
     * @return myColor
     */
    public Color getCurrentColor() { 
        return myColor;
    }
    /**
     * Gets current stroke.
     * @return myStrokeWidth
     */
    public int getStroke() { 
        return myStrokeWidth;
    }


}
