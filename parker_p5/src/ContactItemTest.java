import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(ContactItem.InvalidContactException.class, () -> new ContactItem("", "", "", ""));
    }
    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> new ContactItem("Ryan", "Parker", "123-123-1234", ""));
    }
    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> new ContactItem("", "Parker", "123-123-1234", "ryan@gmail.com"));
    }
    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> new ContactItem("Ryan", "", "123-123-1234", "ryan@gmail.com"));
    }
    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow(() -> new ContactItem("Ryan", "Parker", "", "ryan@gmail.com"));
    }
    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com"));
    }
    @Test
    public void editingFailsWithAllBlankValues() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertThrows(ContactItem.InvalidContactException.class, () -> contactList.update(0, "", "", "", ""));
    }
    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertDoesNotThrow(() -> contactList.update(0, "Jill", "Parker", "321-321-4321", ""));
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertDoesNotThrow(() -> contactList.update(0, "", "Parker", "321-321-4321", "jill@gmail.com"));
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertDoesNotThrow(() -> contactList.update(0, "Jill", "", "321-321-4321", "jill@gmail.com"));
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertDoesNotThrow(() -> contactList.update(0, "Jill", "Parker", "", "jill@gmail.com"));
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertDoesNotThrow(() -> contactList.update(0, "Jill", "Parker", "321-321-4321", "jill@gmail.com"));
    }
    @Test
    public void testToString() {

        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertEquals("Name: Ryan Parker \n Phone Number: 123-123-1234 \n Email Address: ryan@gmail.com ", contactList.get(0).toString());
    }
}