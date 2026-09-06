import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Spongebob Squarepants", new Contact("Spongebob Squarepants", "+1 617 555 0102"));
        contacts.put("John Turing", new Contact("John Turing", "+1 617 555 0103"));
        contacts.put("Thomas Hamilton", new Contact("Thomas Hamilton", "+1 617 555 0104"));
        contacts.put("Bruce Lee", new Contact("Bruce Lee", "+1 617 555 0105"));

        // Step 5: look up a contact
        String lookupName = "Ada Lovelace";
        Contact found = contacts.get(lookupName);
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        // test with a name that does not exist
        String missingName = "John Smith";
        Contact missing = contacts.get(missingName);
        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }

        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}
