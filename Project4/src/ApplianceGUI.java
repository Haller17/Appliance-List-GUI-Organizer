//Andrew Haller
import java.awt.*;
import javax.swing.*;
/**
 * A GUI class for displaying and managing appliance serial numbers.
 * This class integrates with the {@link ApplianceManager} class to get and display the appliances
 * categorized as fridges, dishwashers, and microwaves in separate text areas.
 * 
 * <p>The GUI features a menu bar with options to open files, search for appliances, and quit the application.
 * It uses a {@link FileMenuHandler} to handle menu actions.</p>
 */
public class ApplianceGUI {
	/**
     * Manages appliances and provides access to categorized collections.
     */
	private ApplianceManager manager; 
	/**
     * Displays the list of fridges in the GUI.
     */
	private JTextArea fridgeSec;
	/**
     * Displays the list of dishwashers in the GUI.
     */
	private JTextArea dishwasherSec;
	/**
     * Displays the list of microwaves in the GUI.
     */
	private JTextArea microwaveSec;
	/**
     * The main application window.
     */
	private JFrame myFrame; 
	 /**
     * Creates the GUI with the specified {@link ApplianceManager}.
     * 
     * <p>Initializes the GUI layout, creates text areas for appliance categories, 
     * and sets up a menu bar with file operations and application controls.</p>
     * 
     * @param manager the appliance manager which gives access to the appliance data
     */
	public ApplianceGUI(ApplianceManager manager) {
        this.manager = manager;
        myFrame = new JFrame("Appliance Serial Numbers");  
        myFrame.setLayout(new GridLayout(1, 3));

        fridgeSec = new JTextArea();
        dishwasherSec = new JTextArea();
        microwaveSec = new JTextArea();

        myFrame.add(new JScrollPane(fridgeSec));
        myFrame.add(new JScrollPane(dishwasherSec));
        myFrame.add(new JScrollPane(microwaveSec));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        JMenuItem searchMenuItem = new JMenuItem("Search");

        FileMenuHandler fileMenuHandler = new FileMenuHandler(this, manager);
        openMenuItem.addActionListener(fileMenuHandler);
        quitMenuItem.addActionListener(fileMenuHandler);
        searchMenuItem.addActionListener(fileMenuHandler);  

        fileMenu.add(openMenuItem);
        fileMenu.add(searchMenuItem);  
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        
        myFrame.setJMenuBar(menuBar);
        myFrame.setSize(800, 400);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
	/**
     * Updates the contents of the text areas in the GUI to display the latest appliance data.
     * 
     * <p>Gets appliances from the {@link ApplianceManager} and updates the
     * correct text areas for fridges, dishwashers, and microwaves.</p>
     */
    public void updateGUI() {
        fridgeSec.setText("");
        dishwasherSec.setText("");
        microwaveSec.setText("");
      
        /**
         * These 3 objects, gets the collection of the serial number objects stored in the ApplianceManager. 
         * For example, getFridges() returns a treemap, and .values() retrieves all the values from that map.
         * The toArray() method converts this collection into an array of Objects, storing the result in an array
         */
        
        //Object is the root of the class hierarchy, From Dr.Lord slides
        Object[] fridgeArray = manager.getFridges().values().toArray(); 
        for (int i = 0; i < fridgeArray.length; i++) {
            fridgeSec.append(fridgeArray[i].toString() + "\n");
        }

        Object[] dishwasherArray = manager.getDishwashers().values().toArray();
        for (int i = 0; i < dishwasherArray.length; i++) {
            dishwasherSec.append(dishwasherArray[i].toString() + "\n");
        }

        Object[] microwaveArray = manager.getMicrowaves().values().toArray();
        for (int i = 0; i < microwaveArray.length; i++) {
            microwaveSec.append(microwaveArray[i].toString() + "\n");
        }
    }
    /**
     * Returns the main application window (JFrame).
     * 
     * @return the JFrame representing the main application window
     */
    public JFrame getMyFrame() {
        return myFrame;
    }
}
