//import java.util.Scanner;
//// local date !!!!
//public class App {
//    public static void main(String[] args) {
//        boolean whileLoop = true;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Welcome to the To-Do List Planner");
//
//        while (whileLoop) {
//            System.out.println("What would you like to do?");
//            System.out.println("1) create a new list \n" +
//                    "2) load an existing list \n" +
//                    "3) quit \n");
//
//            String response = sc.nextLine();
//            if (response == "1") {
//                System.out.println("A new List had been created \n");
//                System.out.println("Enter a name for your Task List:");
//                String taskListName = sc.nextLine();
//
//                TaskList.createList(taskListName);
//
//                boolean whileLoop2 = true;
//                while(whileLoop2) {
//                    System.out.println("What would you like to do?");
//                    System.out.println("1. view the list\n" +
//                            "2. add an item\n" +
//                            "3. edit an item\n" +
//                            "4. remove an item\n" +
//                            "5. mark an item as completed\n" +
//                            "6. un-mark an item as completed\n" +
//                            "7. save the current list\n" +
//                            "8. quit to the main menu");
//                    String response2 = sc.nextLine();
//
//                    switch (response2) {
//                        case "1":
//                            // Display all items in current list
//                            break;
//                        case "2":
//                            System.out.println("Please enter the name of your task:");
//                            String title = sc.nextLine();
//
//                            System.out.println("Please enter a description for your task:");
//                            String description = sc.nextLine();
//                            boolean loop = true;
//
//                            int YYYY = 0;
//                            int DD = 0;
//                            int MM = 0;
//
//                            while (loop) {
//                                System.out.println("Please enter the month this task is due:");
//                                MM = sc.nextInt();
//
//                                if (MM <= 0 || MM > 12) {
//                                    System.out.println("Invalid month");
//                                } else {
//                                    loop = false;
//                                }
//                            }
//
//                            loop = true;
//                            while (loop) {
//                                System.out.println("Please enter the day of the month this task is due:");
//                                DD = sc.nextInt();
//
//                                if (DD <= 0 || DD > 12) {
//                                    System.out.println("Invalid day");
//                                } else {
//                                    loop = false;
//                                }
//                            }
//
//                            loop = true;
//                            while (loop) {
//                                System.out.println("Please enter the year this task is due:");
//                                YYYY = sc.nextInt();
//
//                                if (YYYY <= 0 || YYYY > 12) {
//                                    System.out.println("Invalid Year");
//                                } else {
//                                    loop = false;
//                                }
//                            }
//
//                            String date = YYYY + "-" + MM + "-" + DD;
//
//                            TaskItem.addItem(title, description, date);
//
//                            System.out.println(title + " has been added to the list.");
//                            // .add an item to the list
//                    }
//                } else if(response == "2") {
//
//                } else if(response == "3") {
//
//                } else {
//
//                }
//
//                boolean taskListBool = true;
//
//                while (taskListBool) {
//                    switch (response) {
//                        case "1":
//
//                            break;
//                        case "3":
//                            // ask which item to edit
//                            // edit the item in the list
//                            break;
//                        case "4":
//                            // delete an item in the current list
//                            break;
//                        case "5":
//                            // display all unfinished items
//                            // change an item in the list as done
//                            break;
//                        case "6":
//                            // display all finished items
//                            // change an item in list as unfinished
//                            break;
//                        case "7":
//                            // save the list to the array list
//                            break;
//                        case "8":
//                            // exit for loop
//                            taskListBool = false;
//                            break;
//                        default:
//                            System.out.println("That is not an option please try again");
//                            sc.nextLine();
//                            break;
//                    }
//                    break;
//                    case "2":
//                        System.out.println("Please enter the filename of your list: ");
//                        String filename = sc.nextLine();
//
//                        break;
//                    case "3":
//                        whileLoop = false;
//                    default:
//                        System.out.println("That is not an option please try again");
//                        sc.nextLine();
//                }
//            }
//        }
//    }
//}
//
