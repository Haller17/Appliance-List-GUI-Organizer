// Andrew Haller

/**
 *(1 of 3 Appliance subclasses) 
 *<p> Represents a refrigerator appliance with its own unique feature. Cubic feet.
 
 *<p>The {@code Refrigerator} class extends the {@link Appliance} class by adding
 * a cubic feet property that specifies the amount of space the refrigerator takes up.</p>
 */
public class Refrigerator extends Appliance {
    /** The amount of space the refrigerator takes up in cubic feet */
    private double cubicFeet;

    /**
     * Constructs a new {@code Refrigerator} instance with the specified serial number, price, and storage space.
     *
     * @param serialNumber The unique identifier for the refrigerator
     * @param price The cost of the refrigerator
     * @param cubicFeet The storage capacity of the refrigerator in cubic feet
     */
    public Refrigerator(String serialNumber, double price, double cubicFeet) {
        super(serialNumber, price);
        this.cubicFeet = cubicFeet;
    }

    /**
     * Gets the storage capacity of the refrigerator.
     *
     * @return In cubic feet, the capacity of the refrigerator
     */
    public double getCubicFeet() {
        return cubicFeet;
    }

    /**
     * Returns a string representation of the refrigerator.
     *
     * @return A string containing the serial number, price, and cubic feet capacity of the refrigerator
     */
    public String toString() {
        return getSerialNumber() + ", $" + getPrice() + ", " + cubicFeet + "FT^3";
    }
}
