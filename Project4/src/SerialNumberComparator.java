//Andrew Haller
import java.util.Comparator;
/**
 * A comparator for comparing appliance serial numbers represented as {@link String}s.
 * 
 * <p>This class implements the {@link Comparator} interface and defines a natural
 * lexicographical order for serial numbers using {@link String#compareTo(String)}.</p>
 */
public class SerialNumberComparator implements Comparator<String> {
	 /**
     * Compares two serial numbers lexicographically.
     * 
     * @param serial_one the first serial number to compare
     * @param serial_two the second serial number to compare
     * @return a negative integer, zero, or a positive integer as {@code serial_one}
     *         is less than, equal to, or greater than {@code serial_two}
     */
	public int compare(String serial_one, String serial_two) {
        return serial_one.compareTo(serial_two);
    }//compare
}//class
