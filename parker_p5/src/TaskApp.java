import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    private static final Scanner input = new Scanner(System.in);
    private TaskList taskList;

    private void displayTaskMenu() {
        System.out.println("Task List Menu:");
        System.out.println("--------------");
        System.out.println();
        System.out.println("1) create task list");
        System.out.println("2) load task list");
        System.out.println("3) quit to main menu");
        System.out.println();
    }

    public void runTaskMenu() {
        String taskMenuResponse;
        while(true) {
            displayTaskMenu();
            taskMenuResponse = getTaskMenuChoice();
            if (taskMenuResponse.contains("1") || taskMenuResponse.contains("create")) {
                createTaskList();
                taskListActions();
            } else if (taskMenuResponse.startsWith("2") || taskMenuResponse.contains("load")) {
                try {
                    loadTaskList();
                    taskListActions();
                } catch(InputMismatchException | IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (taskMenuResponse.startsWith("3") || taskMenuResponse.contains("quit")) {
                break;
            } else {
                System.out.println("Invalid menu response. Please try again");
            }
        }
    }

    private void createTaskList() {
        taskList = new TaskList();
        System.out.println("A new task list has been created.");
    }

    private void loadTaskList() {
        taskList = new TaskList();
        System.out.printf("Enter the filename of your task list: ");
        String fileName = input.nextLine();
        taskList.loadList(fileName);
        System.out.println(fileName + " has been loaded.");
    }

    private void displayTaskActions() {
        System.out.println("Task List Actions:");
        System.out.println("-----------------");
        System.out.println("1) view task list");
        System.out.println("2) add task item");
        System.out.println("3) edit task item");
        System.out.println("4) remove task item");
        System.out.println("5) mark task *Completed*");
        System.out.println("6. unmark task");
        System.out.println("7) save task list");
        System.out.println("8) exit to task menu");
        System.out.println();
    }

    private void taskListActions() {
        String taskMenuResponse;
        while(true) {
            displayTaskActions();
            taskMenuResponse = getTaskMenuChoice();
            if (taskMenuResponse.contains("1") | taskMenuResponse.contains("view")) {
                if(taskList.size() > 0) {
                    System.out.println(taskList.viewAllTasks());
                } else {
                    System.out.println("There are no tasks to view");
                }
            } else if (taskMenuResponse.contains("2") | taskMenuResponse.contains("add")) {
                    addTask();
            } else if (taskMenuResponse.contains("3") | taskMenuResponse.contains("edit")) {
                if (taskList.size() > 0) {
                    editTask();
                } else {
                    System.out.println("First you must add a task.");
                }
            } else if (taskMenuResponse.contains("4") | taskMenuResponse.contains("remove")) {
                if (taskList.size() > 0) {
                    removeTask();
                } else {
                    System.out.println("First you must add a task.");
                }
            } else if (taskMenuResponse.contains("5") | taskMenuResponse.contains("mark")) {
                if (taskList.size() > 0) {
                    markTask();
                } else {
                    System.out.println("First you must add a task.");
                }
            } else if (taskMenuResponse.contains("6") | taskMenuResponse.contains("unmark")) {
                if (taskList.size() > 0) {
                    unmarkTask();
                } else {
                    System.out.println("First you must add a task.");
                }
            } else if (taskMenuResponse.contains("7") | taskMenuResponse.contains("save")) {
                if (taskList.size() != 0) {
                    saveTaskList();
                } else {
                    System.out.println("There are no tasks added to this Task List.");
                }
            } else if (taskMenuResponse.contains("8") | taskMenuResponse.contains("exit")) {
                break;
            } else {
                System.out.println("Invalid action. Please try again");
            }
        }
    }

    private void addTask() {
        System.out.printf("Enter a Title: ");
        String title = input.nextLine();

        System.out.printf("Enter a Description: ");
        String description = input.nextLine();

        System.out.printf("Enter a Due Date in (YYYY-MM-DD) format: ");
        String date = input.nextLine();

        try {
            taskList.add(new TaskItem(title, description, date));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void editTask() {
        showTasks();

        System.out.println("Which task would you like to edit?");
        int response = input.nextInt();
        input.nextLine();

        if(response < taskList.size()) {
            System.out.printf("Enter a new Title for task %d: ", response);
            String title = input.nextLine();

            System.out.printf("Enter a new Description for task %d: ", response);
            String description = input.nextLine();

            System.out.printf("Enter a new Date for task %d in (YYYY-MM-DD) format: ", response);
            String date = input.nextLine();

            try {
                taskList.update(response, title, description, date);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("There is no task number with that index.");
        }
    }

    private void removeTask() {
        showTasks();

        System.out.println("Which task would you like to remove?");
        int response = input.nextInt();
        input.nextLine();

        if(response < taskList.size()) {
            taskList.remove(response);
        } else {
            System.out.println("There is no task number with that index.");
        }
    }

    private void markTask() {
        showUncompletedTasks();

        System.out.println("Which task would you like to mark -COMPLETED-?");
        int response = input.nextInt();
        input.nextLine();
        if (taskList.size() <= response) {
            System.out.println("There is no task with that number.");
        } else if(taskList.isTaskCompleted(response)) {
            System.out.println("This task is already marked as completed.");
        } else {
            taskList.complete(response, true);
        }
    }

    private void unmarkTask() {
        showCompletedTasks();

        System.out.println("Which task would you like to unmark?");
        int response = input.nextInt();
        input.nextLine();
        if (taskList.size() <= response) {
            System.out.println("There is no task with that number.");
        } else if(!taskList.isTaskCompleted(response)) {
            System.out.println("This task is not marked as completed.");
        } else {
            taskList.complete(response, false);
        }
    }

    private void saveTaskList() {
        System.out.print("Enter a filename to save: ");
        String fileName = input.nextLine();
        taskList.saveList(fileName);

        System.out.println(fileName + " has been saved.");
    }

    private void showTasks() {
        System.out.println("All Tasks:");
        System.out.println("----------");
        System.out.println(taskList.viewAllTasks());
    }

    private void showCompletedTasks() {
        System.out.println("Completed Tasks:");
        System.out.println("----------------");
        System.out.println(taskList.viewCompletedTasks());
    }

    private void showUncompletedTasks() {
        System.out.println("Uncompleted Tasks:");
        System.out.println("------------------");
        System.out.println(taskList.viewUncompletedTasks());
    }

    private String getTaskMenuChoice() {
        System.out.print("> ");
        return input.nextLine();
    }
}
