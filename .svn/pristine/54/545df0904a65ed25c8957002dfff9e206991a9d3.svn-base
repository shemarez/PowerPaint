package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
/**
 * Creates a Line. Draws a line when
 * mouse is pressed, and dragged. Returns
 * a line when square circle is done.
 * @author Shema Rezanejad
 * @version 1
 *
 */

public class LineListener extends AbstractTools {
    /** The start point. */
    private Point myStartPoint;
    /** The Current shape. */
    private Line2D myCurrentShape;

    
    /**
     * Constructor, calls super.
     */
    public LineListener() {
        super("Line");
    }
    @Override
    public Shape drawShapes(final Point theStartPoint, final Point theEndPoint) {
        myStartPoint = theStartPoint;
        myCurrentShape = new Line2D.Double(theStartPoint.x, theStartPoint.y,
                                               theEndPoint.x, theEndPoint.y); 
        return myCurrentShape;
        
    }
    @Override
    public Shape moveShape(final Point theStartPoint, final Point theEndPoint) {
        myCurrentShape.setLine(myStartPoint.x, myStartPoint.y, theEndPoint.x, theEndPoint.y);
        
        return myCurrentShape;
    
    }
    @Override
    public Shape moveOnlySquare(final Point theStartPoint, final Point theEndPoint) {
        myCurrentShape.setLine(myStartPoint.x, myStartPoint.y, theEndPoint.x, theEndPoint.y);
        return myCurrentShape;
    }
    @Override
    public Shape getShape() {
        return myCurrentShape;
    }

}
