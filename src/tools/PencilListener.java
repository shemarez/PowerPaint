/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
/**
 * Creates a pencil shape using points and a
 * general path.
 * @author Shema Rezanejad
 * @version 1
 *
 */

public class PencilListener extends AbstractTools {
    /** Current shape. */
    private Shape myCurrentShape;
    /** The path. */
    private GeneralPath myPath;
    
    /** Constructor, initializes the general path. */
    public PencilListener() {
        super("Pencil");
        myCurrentShape = new GeneralPath();
    }
    @Override
    public Shape drawShapes(final Point theStartPoint, final Point theEndPoint) { 
        myPath = new GeneralPath();
        myPath.moveTo(theStartPoint.getX(), theStartPoint.getY());
        myPath.lineTo(theEndPoint.getX(), theEndPoint.getY());

        return myPath;
    }

    @Override
    public Shape moveShape(final Point theStartPoint, final Point theEndPoint) {
        myPath.lineTo(theEndPoint.getX(), theEndPoint.getY());

        return myPath;
    }
    @Override
    public Shape moveOnlySquare(final Point theStartPoint, final Point theEndPoint) {
        myPath.lineTo(theEndPoint.getX(), theEndPoint.getY());
        return myPath;
    }
    @Override
    public Shape getShape() {
        myCurrentShape = myPath;
        return myCurrentShape;
    }



}
