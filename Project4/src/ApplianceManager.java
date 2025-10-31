//Andrew Haller
import java.util.TreeMap;
/**
 * This class manages the collections of appliances, categorized as fridges, dishwashers, and microwaves.
 * 
 * <p>This class organizes appliances into three separate {@link TreeMap}s using their serial numbers
 * as keys, ensuring that the appliances are stored in sorted order based on the serial numbers.
 * <p>I use a comparator ({@link SerialNumberComparator}) to take care of the sorting.</p>
 * 
 * <p>Quick points:
 * <ul>
 *   <li>Automatically categorizes appliances by type based on their serial numbers.</li>
 *   <li>Provides access to sorted collections of appliances for each category.</li>
 */
public class ApplianceManager {
	/**
     * A {@link TreeMap} storing fridge appliances, sorted by their serial numbers.
     */
	private TreeMap<String, Appliance> fridges;
	/**
     * A {@link TreeMap} storing dishwasher appliances, sorted by their serial numbers.
     */
	private TreeMap<String, Appliance> dishwashers;
	/**
     * A {@link TreeMap} storing microwave appliances, sorted by their serial numbers.
     */
	private TreeMap<String, Appliance> microwaves;
	
	/**
     * Constructs the {@code ApplianceManager} and initializes the three categorized
     * {@link TreeMap}s  
     * <p> for fridges, dishwashers, and microwaves, which is sorted using the {@link SerialNumberComparator}.
     */
	public ApplianceManager() {
        SerialNumberComparator comparator = new SerialNumberComparator();
        
        fridges = new TreeMap<>(comparator);  
        dishwashers = new TreeMap<>(comparator); 
        microwaves = new TreeMap<>(comparator);  
    }
	/**
     * Adds an {@link Appliance} to the correct category based on its serial number.
     * 
     * <p>Based on the first character of the serial number it figures out the category:
     * <ul>
     *   <li>'R' - Fridge</li>
     *   <li>'D' - Dishwasher</li>
     *   <li>'M' - Microwave</li>
     * </ul>
     * </p>
     * 
     * @param appliance the appliance to be added
     */
	
    public void add(Appliance appliance) {
        char type = appliance.getSerialNumber().charAt(0);

        // Sort the appliances by case (R,D,M)
        if (type == 'R') {
            fridges.put(appliance.getSerialNumber(), appliance);
        } else if (type == 'D') {
            dishwashers.put(appliance.getSerialNumber(), appliance);
        } else if (type == 'M') {
            microwaves.put(appliance.getSerialNumber(), appliance);
        }
    }
    /**
     * Returns the collection of fridges managed by the {@code ApplianceManager}.
     * 
     * @return a {@link TreeMap} of fridge appliances, thats sorted by serial number
     */
    public TreeMap<String, Appliance> getFridges() {
        return fridges;
    }
    /**
     * Returns the collection of dishwashers managed by the {@code ApplianceManager}.
     * 
     * @return a {@link TreeMap} of dishwasher appliances, thats sorted by serial number
     */
    public TreeMap<String, Appliance> getDishwashers() {
        return dishwashers;
    }
    /**
     * Returns the collection of microwaves managed by the {@code ApplianceManager}.
     * 
     * @return a {@link TreeMap} of microwave appliances, thats sorted by serial number
     */
    public TreeMap<String, Appliance> getMicrowaves() {
        return microwaves;
    } 
}
