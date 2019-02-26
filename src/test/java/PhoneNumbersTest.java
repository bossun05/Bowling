import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PhoneNumbersTest {

    private List<String> phoneNumberList = new ArrayList<>();


    @Test
    public void testAllNumbersInconsistent() {
        setInconsistentPhoneNumbers();
        PhoneNumbers phoneNumbers = new PhoneNumbers(phoneNumberList);
        assertEquals("Inconsistent", phoneNumbers.checkNumbers());
    }

    @Test
    public void testAllNumbersConsistent() {
        setConsistentPhoneNumbers();
        PhoneNumbers phoneNumbers = new PhoneNumbers(phoneNumberList);
        assertEquals("Consistent", phoneNumbers.checkNumbers());
    }

    private void setInconsistentPhoneNumbers() {
        phoneNumberList.add("Bob,91-12 5426");
        phoneNumberList.add("Alice,97625992");
        phoneNumberList.add("Emergency,911");
    }

    private void setConsistentPhoneNumbers() {
        phoneNumberList.add("Bob,91-22 5426");
        phoneNumberList.add("Alice,97625992");
        phoneNumberList.add("Emergency,911");
    }

}