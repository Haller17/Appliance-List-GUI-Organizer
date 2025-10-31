// Andrew Haller

/**
 * (3 of 3 Appliance subclass)
 * <p>Represents a microwave appliance with its own unique feature. A specified amount of watts it takes.
 *
 * <p>The {@code Microwave} class extends the {@link Appliance} class by adding a watts property
 * that specifies the amount of watts the microwave uses.</p>
 */
public class Microwave extends Appliance {
    /** The power of the microwave in watts */
    private int watts;

    /**
     * Constructs a new {@code Microwave} instance with the specified serial number, price, and watts.
     *
     * @param serialNumber The unique identifier for the microwave
     * @param price The cost of the microwave
     * @param watts The power of the microwave in watts
     */
    public Microwave(String serialNumber, double price, int watts) {
        super(serialNumber, price);
        this.watts = watts;
    }

    /**
     * Gets the wattage of the microwave.
     *
     * @return The wattage of the microwave
     */
    public int getWatts() {
        return watts;
    }

    /**
     * Returns a string representation of the microwave.
     *
     * @return A string containing the serial number, price, and wattage of the microwave
     */
    public String toString() {
        return getSerialNumber() + ", $" + getPrice() + ", " + watts + "W";
    }
}
