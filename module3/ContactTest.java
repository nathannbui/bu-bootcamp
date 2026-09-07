import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        Contact grace = new Contact("Grace Hopper", "555-0000");
        assertEquals("Grace Hopper", grace.getName());
    }

    @Test
    void toString_containsName() {
        Contact alan = new Contact("Alan Turing", "555-0001");
        assertTrue(alan.toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        Contact alan = new Contact("Alan Turing", "555-0001");
        assertTrue(alan.toString().contains("555-0001"));
    }
}
