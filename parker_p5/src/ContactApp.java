import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    private static final Scanner input = new Scanner(System.in);
    private ContactList contactList;


    private void displayContactMenu() {
        System.out.println("Contact List Menu:");
        System.out.println("--------------");
        System.out.println();
        System.out.println("1) create contact list");
        System.out.println("2) load contact list");
        System.out.println("3) quit to main menu");
        System.out.println();
    }
    public void runContactMenu() {
        String contactMenuResponse;
        while(true) {
            displayContactMenu();
            contactMenuResponse = getContactMenuChoice();
            if (contactMenuResponse.contains("1")) {
                createContactList();
                contactMenuActions();
            } else if (contactMenuResponse.startsWith("2")) {
                try {
                    loadContactList();
                    contactMenuActions();
                } catch(InputMismatchException | IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (contactMenuResponse.startsWith("3")) {
                break;
            } else {
                System.out.println("Invalid menu response. Please try again");
            }
        }
    }

    private void createContactList() {
        contactList = new ContactList();
        System.out.println("A new contact list has been created.");
    }

    private void loadContactList() {
        contactList = new ContactList();
        System.out.printf("Enter the filename of your contact list: ");
        String fileName = input.nextLine();
        contactList.loadList(fileName);
        System.out.println(fileName + " has been loaded.");
    }

    private void displayContactActions() {
        System.out.println("Contact List Actions:");
        System.out.println("-----------------");
        System.out.println("1) view a contacts");
        System.out.println("2) add a contact");
        System.out.println("3) edit a contact");
        System.out.println("4) remove a contact");
        System.out.println("5) save contacts");
        System.out.println("6) exit to contact menu");
        System.out.println();
    }

    private void contactMenuActions() {
        String contactMenuResponse;
        while(true) {
            displayContactActions();
            contactMenuResponse = getContactMenuChoice();
            if (contactMenuResponse.contains("1")) {
                if(contactList.size() > 0) {
                    System.out.println(contactList.view());
                } else {
                    System.out.println("There are no contacts to view");
                }
            } else if (contactMenuResponse.contains("2")) {
                addContact();
            } else if (contactMenuResponse.contains("3")) {
                if (contactList.size() > 0) {
                    editContact();
                } else {
                    System.out.println("First you must add a contact.");
                }
            } else if (contactMenuResponse.contains("4")) {
                if (contactList.size() > 0) {
                    removeContact();
                } else {
                    System.out.println("First you must add a contact.");
                }
            } else if (contactMenuResponse.contains("5")) {
                if (contactList.size() != 0) {
                    saveContactList();
                } else {
                    System.out.println("There are no contacts added to this Contact List.");
                }
            } else if (contactMenuResponse.contains("6")) {
                break;
            } else {
                System.out.println("Invalid action. Please try again");
            }
        }
    }

    private void addContact() {
        System.out.printf("First Name: ");
        String firstName = input.nextLine();

        System.out.printf("Last Name: ");
        String lastName = input.nextLine();

        System.out.printf("Phone Number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();

        System.out.printf("Email address (x@<domain>.<TLD>): ");
        String emailAddress = input.nextLine();

        try {
            contactList.add(new ContactItem(firstName, lastName, phoneNumber, emailAddress));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void editContact() {
        showContacts();

        System.out.println("Which contact would you like to edit?");
        int response = input.nextInt();
        input.nextLine();

        if(response < contactList.size()) {
            System.out.printf("Enter a new First Name for contact number%d: ", response);
            String firstName = input.nextLine();

            System.out.printf("Enter a new Last Name for contact number %d: ", response);
            String lastName = input.nextLine();

            System.out.printf("Enter a new Phone Number for contact number %d in (xxx-xxx-xxxx) format: ", response);
            String phoneNumber = input.nextLine();

            System.out.printf("Enter a new Email Address for contact number %d in (x@<domain>.<TLD>) format: ", response);
            String emailAddress = input.nextLine();

            try {
                contactList.update(response, firstName, lastName, phoneNumber, emailAddress);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("There is no contact with that index.");
        }
    }

    private void removeContact() {
        showContacts();

        System.out.println("Which contact would you like to remove?");
        int response = input.nextInt();
        input.nextLine();

        if(response < contactList.size()) {
            contactList.remove(response);
        } else {
            System.out.println("There is no contact with that index.");
        }
    }

    private void saveContactList() {
        System.out.print("Enter a filename to save: ");
        String fileName = input.nextLine();
        contactList.saveList(fileName);

        System.out.println(fileName + " has been saved.");
    }

    private void showContacts() {
        System.out.println("All Tasks:");
        System.out.println("----------");
        System.out.println(contactList.view());
    }

    private String getContactMenuChoice() {
        System.out.printf("> ");
        return input.nextLine();
    }
}
