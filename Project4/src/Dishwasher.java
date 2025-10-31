// Andrew Haller

/**
 * (2 of 3 Appliance subclass)
 * Represents a dishwasher appliance with the option of under the counter installation.
 *
 * <p>The {@code Dishwasher} class extends the {@link Appliance} class and includes a unique property
 * to indicate if the dishwasher is designed for under the counter installation.</p>
 */
public class Dishwasher extends Appliance {
    /** Indicates whether the dishwasher is an under the counter model */
    private boolean undercounter;

    /**
     * Constructs a new {@code Dishwasher} instance with the specified serial number, price, and under the counter indicator.
     *
     * @param serialNumber The unique identifier for the dishwasher
     * @param price The cost of the dishwasher
     * @param undercounterIndicator A string that specifies if the dishwasher is an under the counter model.
     */
    public Dishwasher(String serialNumber, double price, String undercounterIndicator) {
        super(serialNumber, price);
        this.undercounter = undercounterIndicator.equals("Y");
    }

    /**
     * Checks if the dishwasher is an under the counter model (Checks the letter at the end of the serial number input to see).
     *
     * @return {@code true} if the dishwasher is a under the counter model (Last letter =  'Y')
     * <p> {@code false} if the dishwasher is NOT a under the counter model (Last letter = anything other than 'Y')
     */
    public boolean isUndercounter() {
        return undercounter;
    }

    /**
     * Returns a string representation of the dishwasher.
     *
     * @return A string containing the serial number, price, and if the dishwasher is a under the counter model.
     */
    public String toString() {
        return getSerialNumber() + ", $" + getPrice() + ", Undercounter: " + undercounter;
    }
}
