//Andrew Haller
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/**
 * Handles menu actions for the appliance management GUI, which includes file operations, quitting the application,
 * and searching for appliances based on what the user asks to search for.
 * 
 * <p>This class implements {@link ActionListener} to respond to menu item selections. It supports opening a file,
 * exiting the application, and filtering appliances based on type and price which is determined by the user. 
 */
public class FileMenuHandler implements ActionListener {
	/**
     * The GUI object for displaying and interacting with appliances.
     */
	private ApplianceGUI applianceGUI;
	/**
     * The manager that organizes appliances by type and gives access to the categorized collections.
     */
	private ApplianceManager manager;
	
	/**
     * Constructs a {@code FileMenuHandler} with the specified GUI and appliance manager.
     * 
     * @param applianceGUI the GUI for displaying appliances
     * @param manager the manager which handles the appliance data
     */
    public FileMenuHandler(ApplianceGUI applianceGUI, ApplianceManager manager) {
        this.applianceGUI = applianceGUI;
        this.manager = manager;
    }//FileMenuHandler
    /**
     * Responds to menu actions by performing the correct operations:
     * <ul>
     *   <li>"Open" - Opens a file and processes its contents to populate the appliance manager.</li>
     *   <li>"Quit" - Exits the application.</li>
     *   <li>"Search" - Prompts the user to filter appliances by type and price.</li>
     * </ul>
     * 
     * @param e the action event thats triggered by a menu item selection
     */
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Open".equals(command)) {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(applianceGUI.getMyFrame()) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Main.readFile(file, manager, applianceGUI);
            }//if(filechooser)
        
        }//if(command)
        else if ("Quit".equals(command)) {
            System.exit(0);
        } else if ("Search".equals(command)) {
            searchApp();
        }//elif
    
    }//actionPerformed

    /**
     * Prompts the user to search for appliances based on the type and <= price.
     * <p>
     * The user inputs a character representing the appliance type (R,D,M) and a price. 
     * The method filters the correct category of appliances
     * and prints those with a price less than or equal to the specified value that the user gave.
     */    
    private void searchApp() {
        String input = JOptionPane.showInputDialog(applianceGUI.getMyFrame(),
                "Enter a first letter of an appliance type (R, D, M) followed by a price:");

        if (input != null && input.contains(",")) {
            String[] parts = input.split(",");
            String applianceType = parts[0];  
            String priceString = parts[1];  

            // Check if the appliance type is strictly "R", "D", or "M" and price is valid
            if (applianceType.equals("R") || applianceType.equals("D") || applianceType.equals("M")) {
                if (isPrice(priceString)) {
                    double price = Double.parseDouble(priceString);

                    // Filter and print appliances based on the input criteria
                    if ("R".equals(applianceType)) {
                        FilteredApp(manager.getFridges().values(), price);
                    } else if ("D".equals(applianceType)) {
                        FilteredApp(manager.getDishwashers().values(), price);
                    } else if ("M".equals(applianceType)) {
                        FilteredApp(manager.getMicrowaves().values(), price);
                    }//elif
                
                }//if(isPrice)
                else {
                    JOptionPane.showMessageDialog(applianceGUI.getMyFrame(), "Please enter a valid price.");
                }//else
            
            }//if(R,D,M) 
            else {
                JOptionPane.showMessageDialog(applianceGUI.getMyFrame(), "Invalid appliance type. Enter R, D, or M.");
            }//else
        
        }//if 
    
    }//searchApp

    /**
     * Validates if the given string can be parsed as a price.
     * 
     * @param priceString the string that needs to be validated
     * @return {@code true} if the string can be parsed as a valid double.
     * if not, then returns {@code false}
     */    
    private boolean isPrice(String priceString) {
        try {
            Double.parseDouble(priceString);
            return true;
        }//try
        catch (NumberFormatException e) {
            return false;
        }//catch
    }//isPrice

    /**
     * Filters a collection of appliances by the specified price and prints the matching appliances.
     * 
     * @param appliances  the appliances that are to be  filtered
     * @param price the maximum price for filtering appliances
     */    private void FilteredApp(Collection<Appliance> appliances, double price) {
        boolean found = false;
        // Convert collection to an array. (Easier to work with)
        Appliance[] applianceArray = appliances.toArray(new Appliance[0]);
        
        for (int i = 0; i < applianceArray.length; i++) {
            Appliance appliance = applianceArray[i];
            if (appliance.getPrice() <= price) {
                System.out.println(appliance);
                found = true;
            }//if
        }//for
        
        if (!found) {
            System.out.println("No appliances found with price less than or equal to $" + price);
        
        }//if
    
     }//FilteredApp

}//class
