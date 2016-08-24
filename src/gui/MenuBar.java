/*
 * TCSS 305 Winter 2016
 * PowerPaint part B
 */

package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * This class creates a the menu bar for the
 * powerPaint JFrame. It returns a complete menu
 * with sub menus and mnemonics. This is 
 * used in the PowerPaintMainGUI class where
 * it is set as the frames toolbar.
 * 
 * @author Shema Rezanejad
 * @version 1
 *
 */
public final class MenuBar extends JFrame {
    /** Generated UID. */
    private static final long serialVersionUID = 1173067086857296724L;

    /** Maximum ticks for JSlider. */
    private static final int MAX_TICKS = 20;

    /** Tick spacing for JSlider. */
    private static final int TICK_SPACING = 5;

    /** Minor tick spacing for JSlider. */
    private static final int MINOR_TICK_SPACING = 1;
    /** For File button. */
    private final JMenu myFileMenu;

    /** For options menu button. */
    private final JMenu myOptionsMenu;

    /** For tools menu button. */
    private final JMenu myToolsMenu;

    /** for help menu buttons. */
    private final JMenu myHelpMenu;

    /** Creates a menu bar. */
    private final JMenuBar myMenuBar;
    /** Stores current DrawingPanel. **/
    private final DrawingPanel myDrawingArea;
    /** Button group for Tools menu. **/ 
    private final ButtonGroup myGroup;
    /** Current Jframe. */
    private final PowerPaintMainGUI myFrame;
    /** Checks if square/circle checkbox is selected. */
    private boolean mySquareCircle;

    /**
     * Constructor, initializes all JMenu items, and fields. 
     * Calls super().
     * @param theDrawingArea current panel
     * @param theFrame JFrame being added to
     */
    public MenuBar(final DrawingPanel theDrawingArea, final PowerPaintMainGUI theFrame) {
        super();
        myMenuBar = new JMenuBar();
        myFileMenu = new JMenu("File");
        myToolsMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        myOptionsMenu = new JMenu("Options");
        myGroup = new ButtonGroup();
        myDrawingArea = theDrawingArea;
        myFrame = theFrame;

    }
    /**
     * Calls all subMenu methods, returns a completed
     * menu bar. 
     * 
     * @return JMenuBar
     */
    public JMenuBar setUpComponents() {

        createSubMenuFile();
        createSubMenuOptions();
        mySquareCircle = false;
        createSubMenuHelp();
        return createMenuBar();

    }
    /**
     * Creates a menubar, sets mnemonics.
     * @return JMenuBar myMenuBar
     */
    private JMenuBar createMenuBar() {
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        myOptionsMenu.setMnemonic(KeyEvent.VK_O);
        myToolsMenu.setMnemonic(KeyEvent.VK_T);
        myHelpMenu.setMnemonic(KeyEvent.VK_H);

        myMenuBar.add(myFileMenu);
        myMenuBar.add(myOptionsMenu);
        myMenuBar.add(myToolsMenu);
        myMenuBar.add(myHelpMenu);

        return myMenuBar;

    }
    /**
     * Creates a sub menu for File menu Item.
     */
    private void createSubMenuFile() { 
        final JMenuItem undo = new JMenuItem("Undo all changes");
        undo.setEnabled(false);
        myFileMenu.addMenuListener(new MenuListener() {
            public void menuCanceled(final MenuEvent theEvent) {  
            }
            public void menuDeselected(final MenuEvent theEvent) {  
            }
            @Override
            public void menuSelected(final MenuEvent theEvent) {
                if (myDrawingArea.isDrawn() && myDrawingArea.getList() > 0) {
                    undo.setEnabled(true);
                    undo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(final ActionEvent theEvent) {
                            myDrawingArea.clear();
                            undo.setEnabled(false);
                        }     
                    });   
                }   
            }   
        });
        final JMenuItem exit = new JMenuItem("Exit");
        
        undo.setMnemonic(KeyEvent.VK_U);
        exit.setMnemonic(KeyEvent.VK_E);
        myFileMenu.add(undo);
        myFileMenu.addSeparator();
        myFileMenu.add(exit);
        
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispose();
            }

        });

    }
    /**
     * Creates sub menu for Options Menu. 
     */
    private void createSubMenuOptions() { 
        final JCheckBoxMenuItem squareCirc = new JCheckBoxMenuItem("Square/Circle only");
        final JMenu thickness = new JMenu("Thickness"); 
        final JMenuItem color = new JMenuItem("Color...");

        color.setMnemonic(KeyEvent.VK_C);
        thickness.setMnemonic(KeyEvent.VK_T);

        myOptionsMenu.add(squareCirc);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(thickness);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(color);
        squareCirc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                if (squareCirc.isSelected()) {
                    mySquareCircle = true;
                    myDrawingArea.setSquareCircle(mySquareCircle);
                } else {
                    mySquareCircle = false;
                    myDrawingArea.setSquareCircle(mySquareCircle);
                }
                
            }

        });
        final ColorItemIcon colorIcon = new ColorItemIcon();
        color.setIcon(colorIcon);
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color colorChosen = JColorChooser.showDialog(null,
                                                                   "JColorChooser Sample"
                                                                   , colorIcon.getColor());
                if (colorChosen != null) {
                    colorIcon.setColor(colorChosen);
                    myDrawingArea.changeColor(colorChosen); 
                }
            }

        });



        thickness.addChangeListener(new ChangeListener() {
            private JSlider mySlider = new JSlider(JSlider.HORIZONTAL, 0,
                                                   MAX_TICKS, TICK_SPACING);
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                mySlider.setMajorTickSpacing(TICK_SPACING);
                mySlider.setMinorTickSpacing(MINOR_TICK_SPACING);
                mySlider.setPaintTicks(true);
                mySlider.setPaintLabels(true);
                final int stroke = mySlider.getValue();
                myDrawingArea.setTheStroke(stroke);
                thickness.add(mySlider);
            }

        });

    }
    /**
     * Creates sub menu for Tools menu.
     * @param theAction the action class
     * @return createdButton 
     */
    public JRadioButtonMenuItem createSubMenuTools(final Action theAction) {

        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);

        myGroup.add(createdButton);
        myToolsMenu.add(createdButton);
        return createdButton;

    }
    /**
     *  Creates sub menu for Help menu.
     */
    private void createSubMenuHelp() {
        final JMenuItem about = new JMenuItem("About...");
        myHelpMenu.add(about);
        about.setMnemonic(KeyEvent.VK_A);

        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final ImageIcon icon = new ImageIcon("images/popeyeIcon.png");
                JOptionPane.showMessageDialog(null,
                                              "TCSS 305 \nWinter 2016 \nShema Rezanejad"
                                                              + "\nEat your spinach kids!",
                                                              about.getText(),
                                                              JOptionPane.INFORMATION_MESSAGE
                                                              , icon);


            }

        });

    }
}
