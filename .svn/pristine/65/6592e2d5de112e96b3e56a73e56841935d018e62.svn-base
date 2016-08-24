package gui;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * Main for PowerPaint. Sets look and 
 * feel to Metal. Calls PowerPaintGUI and 
 * runs it. 
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public final class PowerPaintMain {
    /**
     * Empty constructor.
     */
    private PowerPaintMain() {
        
    }
    /**
     * Main Driver. Sets look and feel,
     * calls PowerPaintGUI.
     * @param theArgs the args
     */
    public static void main(final String[]theArgs) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintMainGUI();
            }
        });
    }

}
