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
//    editingItemsFailsWithAllBlankValues()
//    editingItemsFailsWithInvalidIndex()
//    editingSucceedsWithBlankFirstName()
//    editingSucceedsWithBlankLastName()
//    editingSucceedsWithBlankPhone()
//    editingSucceedsWithNonBlankValues()
    
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
    
//    removingItemsFailsWithInvalidIndex()
//    savedContactListCanBeLoaded()

}