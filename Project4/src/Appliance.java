//Andrew Haller
/**
 * This class represents a generic appliance with a serial number and price.
 * This abstract class also serves as a base for specific appliance types.
 */
public abstract class Appliance {

    /**
     * The unique serial number of the appliance.
     */
    public String serialNumber;

    /**
     * The price of the appliance.
     */
    public double price;

    /**
     * Constructs an {@code Appliance} with a given serial number and price.
     * 
     * @param serialNumber the serial number of the appliance
     * @param the price of the appliance
     * @throws IllegalApplianceException if the serial number is invalid
     */
    public Appliance(String serialNumber, double price) {
     
        this.serialNumber = serialNumber;
        this.price = price;
    }

    /**
     * Handles invalid serial numbers by validating and throwing an exception if invalid.
     * 
     * @param serialNumber the serial number to validate
     * @return {@code true} if the serial number is valid, {@code false} if not
     */
    public static boolean Invalid_Serial_Number(String serialNumber) {
        try {
            if (!isValid(serialNumber)) {
                throw new IllegalApplianceException("Illegal serial number: " + serialNumber);
            }
            return true; // Serial number is valid
        } 
        catch (IllegalApplianceException e) {
            System.out.println(e.getMessage()); // print the error
            return false; // Serial number is invalid
        } //catch
    } //

    /**
     * Retrieves the serial number of the appliance.
     * 
     * @return the serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Retrieves the price of the appliance.
     * 
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Validates the format of a given serial number.
     * The serial number must match the pattern:
     * <code>^[RDM][A-Z0-9]{11}</code>
     * <p>(Starts with either an R, D, or M. And is a 11 character length, with either Caps/lowercase or numbers.)
     * 
     * @param serialNumber the serial number to validate
     * @return {@code true} if the serial number is valid, {@code false} otherwise
     */
    public static boolean isValid(String serialNumber) {
        String regExpression = "^[RDM][A-Z0-9]{11}";
        return serialNumber.matches(regExpression);
    }
}
