import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    private TaskList TaskList;

    public App() {
        TaskList = new TaskList();
    }

    private void mainMenuDisplay() {
        boolean menuAction = true;
        while(menuAction) {
            System.out.println("Main Menu");
            System.out.println("1. Create Task List");
            System.out.println("2. Load Task List");
            System.out.println("3. Quit");
            menuAction = menuAction();
        }

        System.out.println("Goodbye");
    }

    private boolean menuAction() {

        try {
            int action = input.nextInt();

            if (action == 1) {
                taskListAction();
                // TaskList.createTaskList(sc);
                return true;
            } else if (action == 2) {
                return true;
            } else if (action == 3){
                return false;
            } else {
                System.out.println("Invalid Entry. Please try again, numbers 1-3");
                return true;
            }
        } catch(InputMismatchException ex) {
            System.out.println("Invalid entry. Please try again, numbers 1-3");
            input.nextLine();
            return true;
        }
    }

    private void taskListAction() {
        // initialize Tasks as a list of Tasks
        boolean taskAction = true;

        while (taskAction) {
            System.out.println("Task Operator:");
            System.out.println("1. View your Tasks");
            System.out.println("2. Add a Task");
            System.out.println("3. Edit a Task");
            System.out.println("4. Remove a Task");
            System.out.println("5. Mark a Task *Completed*");
            System.out.println("6. Un-mark a *Completed* Task");
            System.out.println("7. Save the Current Task List");
            System.out.println("8. Exit to the Main Menu");

            taskAction = taskOperatorAction();
        }
    }

    private boolean taskOperatorAction() {
        try {
            int taskAction = input.nextInt();

            if (taskAction == 1) {
                TaskList.view();
                return true;
            } else if (taskAction == 2) {
                TaskItem task = getTaskInfo();
                storeTaskItem(task);
                // String taskItem = TaskItem.createTaskItem(sc, taskListArray);
                // taskListArray.add(taskItem);
                return true;
            } else if (taskAction == 3) {
                if (TaskList.size() == 0) {
                    System.out.println("First add a task to your list.");
                } else {
                    int newTaskNum = editPrompt();
                    TaskItem task = getTaskInfo();
                    TaskList.edit(newTaskNum, task);
                }
                return true;
            } else if (taskAction == 4) {
                if (TaskList.size() == 0) {
                    System.out.println("First Add a task to your List.");
                } else {
                    int remTaskNum = removePrompt();
                    TaskList.remove(remTaskNum);
                }
                return true;
            } else if (taskAction == 5) {
                if (TaskList.size() == 0) {
                    System.out.println("First Add a task to your List.");
                } else {
                    int markNum = markPrompt();
//                    MarkedTasks.view();
//                    tl.markCompletedTask(sc, taskListArray, markedTasksArray);
                }
                return true;
//            } else if (taskAction == 6) {
//                if (taskListArray.size() == 0) {
//                    System.out.println("First Add a task to your List.");
//                } else if (markedTasksArray.size() == 0) {
//                    System.out.println("No tasks are marked.");
//                } else {
//                    System.out.println("Which *Completed* task would you like to un-mark?");
//                    tl.viewCurrentTaskList(taskListArray);
//                    tl.unMarkCompletedTask(sc, taskListArray, markedTasksArray);
//                }
//                return true;
//            } else if (taskAction == 7) {
//                if (taskListArray.size() == 0) {
//                    System.out.println("First Add a task to your List.");
//                } else {
//                    // save stuff here
//                }
//                return true;
            } else if (taskAction == 8) {
                return false;
            } else {
                System.out.println("Invalid entry please try again. Enter 1-8");
                return true;
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid entry please try again. Enter 1-8");
            input.nextLine();
            return true;
        }
    }

    private void writeTaskItem() {
        TaskList.write("output.txt");
    }

    private int markPrompt() {
        System.out.println("Which task would you like to mark as *Completed*?");
        TaskList.viewMarked();
        return getMarkResponse();
//        while (true) {
//            try {
//                System.out.println("Which task would you like to mark *COMPLETE*?");
//                TaskList.view();
//                int markNum = input.nextInt();
//                if (TaskList.size() >= markNum) {
//                    System.out.println("Begin removing your task:");
//                    return markNum;
//                } else {
//                    System.out.println("Task number not found, please try again.");
//                }
//            } catch (InputMismatchException ex) {
//                System.out.println("Please only enter a number, try again.");
//                input.nextLine();
//            }
//        }
    }

    private int removePrompt() {
            System.out.println("Which task would you like to remove?");
            TaskList.view();
            return getRemoveEditResponse();
    }

    private int editPrompt() {
            System.out.println("Which task would you like to edit?");
            TaskList.view();
            return getRemoveEditResponse();
    }

    private int getRemoveEditResponse() {
        int response;
        while(true) {
            try {
                response = input.nextInt();
                if (TaskList.size() < response) {
                    System.out.println("Task number not found, please only enter a number for an existing task");
                } else {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please only enter a number, try again.");
                input.nextLine();
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Task not found, please only enter a number for an existing task");
                input.nextLine();
            }
        }
        return response;
    }

    private int getMarkResponse() {
        int response;
        while(true) {
            try {
                response = input.nextInt();
                if(TaskList.size() < response) {
                    System.out.println("");
                }
                for (int i = 0; i < markedItems.size; i++) {

                }
            }
        }
        return response();
    }


    private TaskItem getTaskInfo() {
        TaskItem task = null;
        input.nextLine();
        while (true) {
            try {
                String title = getTaskTitle();
                String date = getDate();
                String description = getDescription();

                task = new TaskItem(title, date, description);
                break;
            } catch (TaskItem.InvalidTitleException ex) {
                System.out.println("Your title was invalid");
            } catch (TaskItem.InvalidDateException ex) {
                System.out.println("Your Date was invalid. Enter in the YYY-MM-DD format:");
            } catch (TaskItem.InvalidDescriptionException ex) {
                System.out.println("Your Description was invalid");
            }
        }
        return task;
    }

    private void storeTaskItem(TaskItem task) {
        TaskList.add(task);
    }

    private String getTaskTitle() {
        System.out.println("Enter the task's Title:");
        return input.nextLine();
    }

    private String getDate() {
        System.out.println("Enter the task's Date in YYYY-MM-DD format:");
        return input.nextLine();
    }

    private String getDescription() {
        System.out.println("Enter the task's Description:");
        return input.nextLine();
    }

    public static void main(String[] args) {
        App a = new App();
        a.mainMenuDisplay();
    }

}