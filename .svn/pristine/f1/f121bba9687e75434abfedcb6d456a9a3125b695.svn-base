/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Creates an Ellipse shape. Allows Ellipse
 * to move, and turn into a circle.
 * @author Shema Rezanejad
 * @version 1
 *
 */

public class EllipseListener extends AbstractTools {
    /** Current shape. */
    private Ellipse2D myCurrentShape;
    /** The start point. */
    private Point myStartPoint;
    /** Ellipse Constructor, calls super.*/
    public EllipseListener() {
        super("Ellipse");
    }
  
    @Override
    public Shape drawShapes(final Point theStartPoint, final Point theEndPoint) {
        myStartPoint = theStartPoint;
        myCurrentShape = new Ellipse2D.Double(theStartPoint.getX(), theStartPoint.getY()
                                               , theEndPoint.getX(), theEndPoint.getY());

        return myCurrentShape;

    }

    @Override
    public Shape moveShape(final Point theStartPoint, final Point theEndPoint) {
        myCurrentShape.setFrameFromDiagonal(myStartPoint.x, myStartPoint.y
                                               , theEndPoint.x, theEndPoint.y);
        return myCurrentShape;
    }
    @Override
    public Shape moveOnlySquare(final Point theStartPoint, final Point theEndPoint) {
        myCurrentShape = new Ellipse2D.Double(myStartPoint.x, myStartPoint.y,
                                                theEndPoint.y, theEndPoint.y);
        
        return myCurrentShape;
    }
    @Override
    public Shape getShape() {

        return myCurrentShape;
    }
    
    


}
