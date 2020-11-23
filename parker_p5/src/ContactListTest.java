import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "", "", "");
        contactList.add(contactItem);
        assertEquals(1, contactList.size());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactList.add(contactItem);

        assertThrows(ContactItem.InvalidContactException.class, () -> contactList.update(0, "", "", "", ""));
    }
    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList contactList = new ContactList();
        contactList.add(new ContactItem("Ryan", "", "", ""));
        assertThrows(IndexOutOfBoundsException.class, () -> contactList.update(10, "Ryan", "", "", ""));
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
    public void newListIsEmpty() {
        ContactList contactList = new ContactList();
        assertEquals(0, contactList.size());
    }
    @Test
    public void removingItemsDecreasesSize() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "", "", "");
        contactList.add(contactItem);
        int tempVal = contactList.size();
        contactList.remove(0);
        assertEquals(tempVal - 1, contactList.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList contactList = new ContactList();
        contactList.add(new ContactItem("Ryan", "", "", ""));
        assertThrows(IndexOutOfBoundsException.class, () -> contactList.remove(10));
    }
    @Test
    public void savedContactListCanBeLoaded() {
        ContactList contactListSaved = new ContactList();
        ContactList contactListLoaded = new ContactList();
        ContactItem contactItem = new ContactItem("Ryan", "Parker", "123-123-1234", "ryan@gmail.com");
        contactListSaved.add(contactItem);
        contactListSaved.saveList("contactTestFile");

        contactListLoaded.loadList("contactTestFile");

        assertEquals(contactListSaved, contactListSaved);
    }
}