/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import tools.PencilListener;
import tools.Tools;
/**
 * Class holds panel where you can draw different shapes on.
 * This class holds mouseListeners and mouseMotionListeners,
 * so that whenever something is dragged on this panel, a tool
 * is chosen, and something is drawn. All shapes added to a 
 * list which is then iterated through to draw each individual shape
 * onto the canvas. This is done so that many shapes may be drawn
 * at once.
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */


public final class DrawingPanel extends JPanel {
    /** Serial version UID.*/
    private static final long serialVersionUID = 2302812257149047261L;
    /** The default width value. */
    private static final int WIDTH = 500; 

    /** The default height value. */
    private static final int HEIGHT = 400;

    /** The minimum size this component should be. */
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, HEIGHT);

    /** Setting stroke thickness. */
    private static final int STROKE_THICKNESS = 5;

    /** UW color number 1. */
    private static final int UW_COLOR1 = 51;

    /** UW color number 2. */
    private static final int UW_COLOR2 = 111;

    /** Setting start point of line. */
    private Point myStartPoint;

    /** Setting end point of line. */
    private Point myEndPoint;
    
    /** Holds current graphics. */
    private Graphics2D myG2d;
    
    /** Checks to see if something is drawn on canvas. */
    private boolean myCanvas;
    
    /** Checks to see if squareCircle is chosen. */
    private boolean mySquareCircle;
    
    /** The Current tool chosen. */
    private  Tools myCurrentTool;
    
    /** The current shape drawn. */
    private Shape myCurrentShape;
    
    /** Default pen color.*/
    private final Color myDefaultColor = new Color(UW_COLOR1, 0, UW_COLOR2); 
    
    /** Current Pen stroke. */
    private int myPenThickness;
    
    /** Will take in current shape, with color, and stroke. */
    private MyShape myShape;

    /** Holds current color. */
    private Color myColor;
    
    /** Holds array of all shapes drawn. */
    private final ArrayList<MyShape> myShapesList;

    /**
     * Empty constructor. Simply calls the 
     * setup components.
     */
    public DrawingPanel() {
        super();
        setUpComponents();
        myCanvas = false;
        myShapesList = new ArrayList<MyShape>();
        myCurrentTool = new PencilListener();
        myPenThickness = STROKE_THICKNESS;
    }
    /**
     * Sets cursor to Cross hair for drawing. Calls
     * mouse Listener method. Initializes the start and
     * end points.
     */
    private void setUpComponents() {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        mouseListeners();
        myStartPoint = new Point();
        myEndPoint = new Point();

    }
    /** Gets the current tool in use.
     * @return current tool */
    public Tools getMyCurrentTool() {
        return myCurrentTool;
    }
    /** Gets list size. 
     * 
     * @return the list size
     */
    public int getList() {
        return myShapesList.size();
    }
    @Override
    public Dimension getMinimumSize() {
        return MIN_SIZE;
    }

    @Override
    public Dimension getPreferredSize() {
        return MIN_SIZE;
    }
    /** Checks if canvas has been drawn on. 
     * 
     * @return boolean myCanvas
     */
    public boolean isDrawn() {
        return myCanvas;
    }
    /** Sets the current tool.
     * 
     * @param theCurrentTool tool in use
     */
    public void setMyCurrentTool(final Tools theCurrentTool) {
        this.myCurrentTool = theCurrentTool;
    }
    /** Sets current shape.
     * 
     * @param theShape current shape
     */
    public void setCurrentShape(final Shape theShape) {
        this.myCurrentShape = theShape;
    }
    /** Sets the stroke of a pen.
     * 
     * @param theWidth width of pen stroke
     */
    public void setTheStroke(final int theWidth) { 

        this.myPenThickness = theWidth;
    }
    /** Sets truth of squareCircle.
     * 
     * @param theSquareCircle boolean of button
     */
    public void setSquareCircle(final boolean theSquareCircle) {
        this.mySquareCircle = theSquareCircle;
    }
    /** Clears arraylist when called in undo. */
    public void clear() {
        myShapesList.clear();
        myG2d.setBackground(Color.WHITE);

        repaint();
        myCanvas = false;
    }
    /** Adds shapes to custom class. */
    public void addShapes() {
        myShape = new MyShape(myCurrentShape, myColor, myPenThickness); 
    }
    /** Changes to current color selected. 
     * 
     * @param theColor current color
     */
    public void changeColor(final Color theColor) {
        myColor = theColor;
    }


    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        myG2d = (Graphics2D) theGraphics;
        myG2d.setPaint(myDefaultColor);
        setBackground(Color.WHITE);
        myG2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                               RenderingHints.VALUE_ANTIALIAS_ON);
        addShapes();
       
        for (final MyShape t: myShapesList) {
            if (t.getStroke() > 0) {
                myG2d.setPaint(t.getCurrentColor());
                myG2d.setStroke(new BasicStroke(t.getStroke())); 
                myG2d.draw(t.getShape()); 
            }
        }
        if (myCanvas) {
            if (myPenThickness > 0) {
                myG2d.setPaint(myColor);
                myG2d.setStroke(new BasicStroke(myPenThickness)); 
                myG2d.draw(myCurrentTool.getShape());
                
            }

        }
    }

    /**
     * Method for mouseListeners. I chose to create anonymous 
     * inner classes to implement my mouseListeners. I chose to
     * do it this way because it is faster, easier, and cleaner code.
     * I chose to put the listeners in a different method because I felt 
     * as though it would look nicer, and would organize my code. 
     */
    private void mouseListeners() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(final MouseEvent theEvent) {
                myCanvas = true;
                myStartPoint = theEvent.getPoint();
                myEndPoint = myStartPoint;
                myCurrentShape = myCurrentTool.drawShapes(myStartPoint
                                                          , myEndPoint);               
                myShape.setCurrentShape(myCurrentShape);
            }
            @Override
            public void mouseReleased(final MouseEvent theEvent) {
                myCurrentShape = getMyCurrentTool().getShape();
                myShape.setCurrentShape(myCurrentShape);
                myShapesList.add(myShape);
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(final MouseEvent theEvent) {
                myEndPoint = theEvent.getPoint();
                if (mySquareCircle) {
                    myCurrentShape = getMyCurrentTool().moveOnlySquare(myStartPoint,
                                                                       myEndPoint);
                    
                } else {
                    myCurrentShape = getMyCurrentTool().moveShape(myStartPoint, myEndPoint);
                    
                }
                
                myStartPoint = myEndPoint;
                repaint();


            }
        });


    }

}
