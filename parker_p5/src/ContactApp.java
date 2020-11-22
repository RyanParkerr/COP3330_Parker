import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    private static final Scanner input = new Scanner(System.in);


    private void displayContactMenu() {

    }
    public void runContactMenu() {
        String contactMenuResponse;
        while(true) {
            displayContactMenu();
            contactMenuResponse = getContactMenuChoice();
            if (contactMenuResponse.contains("1") || contactMenuResponse.contains("create")) {
                createContactList();
                contactMenuActions();
            } else if (contactMenuResponse.startsWith("2") || contactMenuResponse.contains("load")) {
                try {
                    loadContactList();
                    contactMenuActions();
                } catch(InputMismatchException | IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (contactMenuResponse.startsWith("3") || contactMenuResponse.contains("quit")) {
                break;
            } else {
                System.out.println("Invalid menu response. Please try again");
            }
        }
    }

    private String getContactMenuChoice() {
        System.out.printf("> ");
        return input.nextLine();
    }
}
