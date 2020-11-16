/*
    TO-DO LIST:
    - finish test cases
    - DONE fix "update the current task list" so it actually updates the previous list
    - DONE make it do that due date can only be a real date
 */
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    private TaskList TaskList;
    private int markCount = 0;
    private int isLoadedList = 0;

    public App() {
        TaskList = new TaskList();
    }

    private void mainMenuDisplay() {
        boolean menuAction = true;
        while(menuAction) {
            System.out.println("Main Menu");
            System.out.println("1. Create Task List");
            System.out.println("2. Load Task List");
            System.out.println("3. Delete Task List");
            System.out.println("4. Quit");
            menuAction = menuAction();
        }

        System.out.println("Goodbye");
    }

    private boolean menuAction() {

        try {
            int action = input.nextInt();

            if (action == 1) {
                taskListAction(null);
                // TaskList.createTaskList(sc);
                return true;
            } else if (action == 2) {
                isLoadedList = 1;
                String fileName = getExistingFileName();
                loadPreviousTask(fileName);
                taskListAction(fileName);
                return true;
            } else if (action == 3) {
                String fileName = getExistingFileName();
                deleteFile(fileName);
                return true;
            } else if (action == 4) {
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

    private void deleteFile(String fileName) {
        try {
            File f = new File(fileName);
            if(f.delete()) {
                System.out.println(f.getName() + " deleted");   //getting and printing the file name
            } else {
                System.out.println("There is no existing file with that name");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getExistingFileName() {
        String fileName;
        System.out.println("Enter the name of the file: ");
        input.nextLine();
        fileName = input.nextLine() + ".txt";
        return fileName;
    }

    /*
        Pseudo Code:
        - DONE read the return String of getExistingFileName()
        - DONE read the information into a new and filled TaskList of TaskItems
        - DONE call taskListAction()
     */

    private void loadPreviousTask(String fileName) {
        markCount = TaskList.readFile(fileName);
    }

    private void taskListAction(String fileName) {
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
            if(isLoadedList == 0) {
                System.out.println("7. Save the Current Task List");
            } else {
                System.out.println("7. Update the Current Task List");
            }
            System.out.println("8. Exit to the Main Menu");

            taskAction = taskOperatorAction(fileName);
        }
    }

    private boolean taskOperatorAction(String fileName) {
        try {
            int taskAction = input.nextInt();

            if (taskAction == 1) {
                TaskList.view(markCount);
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
                    int editNum = editPrompt();
                    TaskItem task = getTaskInfo();
                    TaskList.edit(editNum, task);
                    if (editNum <= markCount) {
                        markCount -= 1;
                    }
                }
                return true;
            } else if (taskAction == 4) {
                if (TaskList.size() == 0) {
                    System.out.println("First Add a task to your List.");
                } else {
                    int remTaskNum = removePrompt();
                    TaskList.remove(remTaskNum);
                    if(remTaskNum <= markCount) {
                        markCount -= 1;
                    }
                }
                return true;
                /*
                    Pseudo Code:
                    - DONE give indication of completion
                    - DONE move to the top of the array
                    - DONE add one to the markedCount
                    - DONE when saved show mark count at the top
                    - DONE when removed if removeNum is < mark count subtract one from mark count
                 */
            } else if (taskAction == 5) {
                if (TaskList.size() == 0) {
                    System.out.println("First Add a task to your List.");
                } else if(markCount == TaskList.size()) {
                    System.out.println("All Tasks are currently marked");
                } else {
                    int markNum = markPrompt();
                    TaskList.mark(markNum);
                    markCount += 1;
                }
                return true;
                /*
                    Pseudo Code:
                    - DONE move marked task to the end of the list
                    - DONE subtract 1 from mark count
                    - DONE if unMarkNum >= markCount print "only un-mark a marked task" error
                 */
            } else if (taskAction == 6) {
                if (TaskList.size() == 0) {
                    System.out.println("First Add a task to your List.");
                } else if (markCount == 0) {
                    System.out.println("There are currently no marked tasks.");
                } else {
                    int unMarkNum = unMarkPrompt();
                    TaskList.unMark(unMarkNum);
                    markCount -=1;
                }
//                old code:
//                    System.out.println("No tasks are marked.");
//                } else {
//                    System.out.println("Which *Completed* task would you like to un-mark?");
//                    tl.viewCurrentTaskList(taskListArray);
//                    tl.unMarkCompletedTask(sc, taskListArray, markedTasksArray);
//                }
                return true;
            } else if (taskAction == 7) {
                if (TaskList.size() == 0) {
                    System.out.println("First Add a task to your List.");
                } else {
                    // save stuff here
                     if(isLoadedList == 1) {
                        writeTaskItem(fileName);
                     } else {
                        writeTaskItem(getFileName());
                    }
                    TaskList.wipe();
                    isLoadedList = 0;
                }
                return false;
            } else if (taskAction == 8) {
                return leaveTaskListWarning();
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

    private int addMarkCount() {
        return markCount += 1;
    }

    private boolean leaveTaskListWarning() {
        while(true) {
                if (shouldContinue(askShouldContinue())) {
                    TaskList.wipe();
                    markCount = 0;
                    isLoadedList = 0;
                    return false;
                } else {
                    return true;
                }
            }
    }


    private boolean shouldContinue(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    private static String askShouldContinue() {
        System.out.println("By doing this you'll lose your current taskList, are you sure you'd like to do this without saving? \n" +
                            "ENTER y to continue & any other key to cancel");
        input.nextLine();
        return input.nextLine();
    }

    private void writeTaskItem(String fileName) {
        TaskList.write(fileName, markCount);
    }

    private String getFileName() {
        System.out.println("What would you like to name your List: ");
        input.nextLine();
        return input.nextLine() + ".txt";
    }

    private int unMarkPrompt() {
        System.out.println("Which task would you like to un-mark?");
        TaskList.view(markCount);
        return getUnMarkResponse();
    }

    private int markPrompt() {
        System.out.println("Which task would you like to mark?");
        TaskList.view(markCount);
        return getMarkResponse();
    }

    private int removePrompt() {
            System.out.println("Which task would you like to remove?");
            TaskList.view(markCount);
            return getRemoveEditResponse();
    }

    private int editPrompt() {
            System.out.println("Which task would you like to edit?");
            TaskList.view(markCount);
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
                if(markCount > response) {
                    System.out.println("Please only select a task that is not marked.");
                } else if(TaskList.size() <= response) {
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

    private int getUnMarkResponse() {
        int response;
        while(true) {
            try {
                response = input.nextInt();
                /*
                    if we try to un-mark something that is not marked already return an error
                 */
                if(response >= markCount) {
                    System.out.println("Please only select a task that is marked.");
                } else if(TaskList.size() < response) {
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


    private TaskItem getTaskInfo() {
        TaskItem task;
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
//            } catch (TaskItem.InvalidDescriptionException ex) {
//                System.out.println("Your Description was invalid");
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