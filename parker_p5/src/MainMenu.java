import java.util.Scanner;

public class MainMenu {
    private static final Scanner input = new Scanner(System.in);
    private static final TaskApp TaskApp = new TaskApp();
    private static final ContactApp ContactApp = new ContactApp();

    public static void main(String[] args) {
        MainMenu mm = new MainMenu();
        mm.runSystem();
    }

    private void runSystem() {
        String mainMenuResponse;
        while(true) {
            displayMainMenu();
            mainMenuResponse = getMainMenuChoice();
            if (mainMenuResponse.contains("1")) {
                TaskApp.runTaskMenu();
            } else if (mainMenuResponse.startsWith("2")) {
                ContactApp.runContactMenu();
            } else if (mainMenuResponse.startsWith("3")) {
                break;
            } else {
                System.out.println("Invalid menu response. Please try again");
            }
        }
    }
    private void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) exit program");
        System.out.println();
    }

    private String getMainMenuChoice() {
        System.out.print("> ");
        return input.nextLine();
    }
}
