import java.io.File;
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
                deleteFile(getExistingFileName());
            } else if (mainMenuResponse.startsWith("4")) {
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
        System.out.println("3) delete list");
        System.out.println("4) exit program");
        System.out.println();
    }

    private void deleteFile(String fileName) {
        try {
            File f = new File(fileName);
            if(f.delete()) {
                System.out.println(f.getName() + " will be deleted once the program is terminated.");   //getting and printing the file name
            } else {
                System.out.println("There is no existing file with that name");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getMainMenuChoice() {
        System.out.print("> ");
        return input.nextLine();
    }

    private String getExistingFileName() {
        String fileName;
        System.out.println("Enter the name of the file: ");
        fileName = input.nextLine();
        return fileName;
    }
}