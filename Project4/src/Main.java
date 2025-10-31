import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ApplianceManager to manage the list of appliances
        ApplianceManager manager = new ApplianceManager(); 
        
        // Create and display the GUI, passing the manager for interaction with appliance data
        new ApplianceGUI(manager);
    }

    public static void readFile(File data, ApplianceManager manager, ApplianceGUI gui) {
    	TextFileInput in = new TextFileInput(data.getPath()); // NOTE** Needs the TextFileInput class to read in the file.
        String s = in.readLine(); // Reads a line of text from the .txt file and assigns it to the variable s.

        while (s != null) {// if s is NOT null. The loop will continue to run as long as s has a value
            String[] parts = s.split(","); // Split up the current line by each ',' into parts.
            String serialNumber = parts[0]; // "Part 0" is the serial number.
            double price = Double.parseDouble(parts[1]); // "Part 1" is the price.

            // Validate the serial number
            if (Appliance.isValid(serialNumber)) {
                
            char type = serialNumber.charAt(0);  // find the type of appliance based on the first character
            	 // Check the type of appliance using the first character and add it to the treemap
                
            	if (type == 'R') {  
                	double cubicFeet = Double.parseDouble(parts[2]); // "Part 2" is the unique attribute for refrigerators.
                	manager.add(new Refrigerator(serialNumber, price, cubicFeet)); //add it to the treemap
                }//if 'R'
                else if (type == 'D') { 
                	 String undercounter = parts[2]; // "Part 2" is the unique attribute for dishwashers.
                	manager.add(new Dishwasher(serialNumber, price, undercounter)); //add it to the treemap
                }//if 'D'
                else if (type == 'M') {  
                	int watts = Integer.parseInt(parts[2]);// "Part 2" is the unique attribute for refrigerators.
                	manager.add(new Microwave(serialNumber, price, watts)); //add it to the treemap
                
                }//if 'M'
            
            }//if "isValid"
            s = in.readLine(); // Move to the next line.
        }//while
        
        in.close();  // Close the file 
        gui.updateGUI();  // Refresh the GUI to update the new data
    
    }//readfile

}//class
