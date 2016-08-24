/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
/**
 * Creates Rectangle shape based on 
 * Start and end points.
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public class RectangleListener extends AbstractTools {
    /** Start point. */
    private Point myStartPoint;
    /** Current shape. */
    private Rectangle2D myCurrentShape;
    /**
     * Constructor, calls super.
     */
    public RectangleListener() {
        super("Rectangle");
    }


    @Override
    public Shape drawShapes(final Point theStartPoint, final Point theEndPoint) {
        myStartPoint = theStartPoint;
        myCurrentShape = new Rectangle2D.Double(theStartPoint.x, theStartPoint.y,
                                                theEndPoint.x, theEndPoint.y);
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
        myCurrentShape = new Rectangle2D.Double(myStartPoint.x, myStartPoint.x,
                                                theEndPoint.y, theEndPoint.y);

        return myCurrentShape;
    }
    @Override
    public Shape getShape() {
        return myCurrentShape;
    }


}
