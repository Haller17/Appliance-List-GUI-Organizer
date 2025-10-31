//Andrew Haller
/**
 * This class represents an exception thrown when an illegal or invalid appliance-related operation is encountered.
 * This custom exception extends {@link IllegalArgumentException}.
 * 
 * <p>
 * The use case of this is validation failures for appliance properties, 
 * like an invalid serial number
 * 
 */
public class IllegalApplianceException extends IllegalArgumentException {

    /**
     * Serial version UID for serialization.
     */
    private static final long serialVersionUID = 1L; //got this from Dr.Lords labs. (They are very helpful!)

    /**
     * Constructs an {@code IllegalApplianceException} with the custom message.
     * 
     * @param message the detail message describing the reason for the exception
     */
    public IllegalApplianceException(String message) {
        super(message);
    }
}//class
