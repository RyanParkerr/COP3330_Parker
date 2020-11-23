import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ContactList {
    private List<ContactItem> contactList;

    public ContactList() { contactList = new ArrayList<>(); }

    public int size() { return contactList.size(); }

    public void add(ContactItem contactItem) { contactList.add(contactItem); }

    public void remove(int contactItemNumber) { contactList.remove(contactItemNumber); }

    public ContactItem get (int contactItemNumber) { return contactList.get(contactItemNumber); }

//    // the next 4 functions were for JUNIT testing purposes
//    public String getFirstName(int index) { return this.get(index).getFirstName(); }
//
//    public String getLastName(int index) { return this.get(index).getLastName(); }
//
//    public String getPhoneNumber(int index) { return this.get(index).getPhoneNumber(); }
//
//    public String getEmailAddress(int index) { return this.get(index).getEmailAddress(); }
//    // end of JUNIT primary function

    public void update(int index, String firstName, String lastName, String phoneNumber, String emailAddress) {
        ContactItem contactItem = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
        contactList.set(index, contactItem);
    }

    public String view() {
        StringBuilder sb = new StringBuilder();
        ContactItem contactItem;

        for (int i = 0; i < this.size(); i++) {
            contactItem = this.get(i);
            sb.append(String.format("%d) %s%n", i, contactItem));
        }
        return sb.toString();
    }

    public void saveList(String fileName) {
        try(Formatter output = new Formatter(fileName)) {
            output.format("ContactList\n"); // this identifies if the file is a contact list or not
            for (int i = 0; i < contactList.size(); i++) {
                ContactItem contactItem = contactList.get(i);
                output.format(contactItem.getFirstName() + "\n");
                output.format(contactItem.getLastName() + "\n");
                output.format(contactItem.getPhoneNumber() + "\n");
                output.format(contactItem.getEmailAddress() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find this File...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadList(String fileName) {
        List <ContactItem> loadedList = contactList;
        contactList = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(fileName));
            String type = input.nextLine();
            if(type.equalsIgnoreCase("ContactList")) {
                while(input.hasNext()) {
                    String firstName = input.nextLine();
                    String lastName = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String emailAddress = input.nextLine();

                    ContactItem contactItem = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                    this.add(contactItem);
                }
            } else {
                contactList = loadedList;
                throw new InputMismatchException("Filename entered is invalid.");
            }
        } catch (FileNotFoundException ex) {
            contactList = loadedList;
            throw new InputMismatchException("There are no files with that name.");

        } catch (NoSuchElementException ex) {
            contactList = loadedList;
            throw new InputMismatchException("This file is not a valid task list.");
        }
    }
}
