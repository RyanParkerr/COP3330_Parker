import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;


public class TaskList {
    List<TaskItem> taskList;
    private static Scanner input = new Scanner(System.in);

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void add(TaskItem task) {
        taskList.add(task);
    }

    public void view(int markCount) {
        if (taskList.size() == 0) {
            System.out.println("There are currently no tasks added to this Task List.");
        } else {
            for (int i = 0; i < markCount; i++) {
                TaskItem task = taskList.get(i);
                System.out.printf(i + ".) ");
                System.out.println("[" + task.getDate() + "] " + task.getTitle() + " " + task.getDescription() + " *COMPLETED*");
            }
            for (int i = markCount; i < taskList.size(); i++) {
                TaskItem task = taskList.get(i);
                System.out.printf(i + ".) ");
                System.out.println("[" + task.getDate() + "] " + task.getTitle() + " " + task.getDescription());
            }
        }
    }

    public void write(String filename, int markCount) {
        try(Formatter output = new Formatter(filename)) {
//            output.format(filename + ":\n");
            output.format(markCount + " COMPLETED TASKS" + "\n");
            for (int i = 0; i < markCount; i++) {
                TaskItem task = taskList.get(i);
                output.format("[" + task.getDate() + "] " + task.getTitle() + " " + task.getDescription() + " *COMPLETED*" + "\n");
            }
            for (int i = markCount; i < taskList.size(); i++) {
                TaskItem task = taskList.get(i);
                output.format("[" + task.getDate() + "] " + task.getTitle() + " " + task.getDescription() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find this File...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public int size() {
        return taskList.size();
    }

    public void edit(int editNumber, TaskItem task) {
        taskList.set(editNumber, task);
        System.out.println("Task " + editNumber + " has been edited");
    }

    public void remove(int remNum) {
        taskList.remove(remNum);
    }

    public void mark(int markNum) {
        taskList.add(0, taskList.get(markNum));
        taskList.remove(markNum + 1);
    }

    public void unMark(int unMarkNum) {
//        taskList.add(taskList.size(), taskList.get(unMarkNum));
//        taskList.remove(unMarkNum + 1);
                TaskItem tempTask = taskList.get(unMarkNum);
                taskList.remove(unMarkNum);
                taskList.add(tempTask);
    }

    public void wipe() {
        int iterations =taskList.size();
        for (int i = 0; i < iterations; i++) {
            taskList.remove(0);
        }
    }
//        int taskRemoveNumber;
//        int sizeOfArray = taskListArray.size();
//        boolean completionBoo = true;
//
//        while(completionBoo) {
//            try {
//                taskRemoveNumber = sc.nextInt();
//                if (sizeOfArray >= taskRemoveNumber) {
//                    taskListArray.remove(taskRemoveNumber);
//                    for (int i = 0; i < markedTasksArray.size(); i++) {
//                        int tempVal = (int) markedTasksArray.get(i);
//                        tempVal = tempVal - 1;
//                        markedTasksArray.set(i, tempVal);
//                    }
//                    System.out.println("Task number " + taskRemoveNumber + " has been removed from your list.");
//                    completionBoo = false;
//                } else {
//                    System.out.println("Task number not found, please try again");
//                    completionBoo = true;
//                }
//            } catch(InputMismatchException e) {
//                System.out.println("Please only enter a number, try again");
//                sc.nextLine();
//                completionBoo = true;
//            }
//        }
//    }
//
//    private void markCompletedTask(Scanner sc, ArrayList taskListArray, ArrayList markedTaskArray) {
//        int taskMarkNumber;
//        boolean completionBool = true;
//        int count = 0;
//
//        while(completionBool) {
//            try {
//                taskMarkNumber = sc.nextInt();
//                for (int i = 0; i < markedTaskArray.size(); i++) {
//                    // if the task of index taskMarkNumber is already marked return error
//                    int currentMarkedItem = (int) markedTaskArray.get(i);
//                    if (currentMarkedItem == taskMarkNumber) {
//                        System.out.println("This item is already marked as *Completed*, try again");
//                        count += 1;
//                    }
//                }
//                if (count == 0) {
//                    // otherwise mark it completed
//                    taskListArray.set(taskMarkNumber, "*Completed* " + taskListArray.get(taskMarkNumber));
//
//                    // add the index of taskMarkNumber to the markedTaskArray
//                    markedTaskArray.add(taskMarkNumber);
//                    completionBool = false;
//                } else {
//                    count = 0;
//                }
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("There is no Task with that number, please try again.");
//                sc.nextLine();
//                completionBool = true;
//                count = 0;
//            } catch (InputMismatchException e) {
//                System.out.println("Please only enter a number, try again.");
//                sc.nextLine();
//                completionBool = true;
//                count = 0;
//            }
//        }
//
//    }
//
//    private void unMarkCompletedTask(Scanner sc, ArrayList taskListArray, ArrayList markedTasksArray) {
//        int taskUnMarkNumber;
//        boolean completionBool = true;
//        int count = 0;
//
//        while(completionBool) {
//            try {
//                taskUnMarkNumber = sc.nextInt();
//                for (int i = 0; i < markedTasksArray.size(); i++) {
//                    int currentlyMarkedItem = (int) markedTasksArray.get(i);
//                    if(currentlyMarkedItem == taskUnMarkNumber) {
//                        count += 1;
//                    }
//                }
//                if(count > 0) {
//                    taskListArray.set(taskUnMarkNumber, unMarkItem(taskListArray, taskUnMarkNumber));
//                    System.out.println("Task " + taskUnMarkNumber + " has been Un-Marked.");
//                    markedTasksArray.remove(markedTasksArray.indexOf(taskUnMarkNumber));
//                    completionBool = false;
//                } else {
//                    System.out.println("Task " + taskUnMarkNumber + " is invalid. Only select a Marked Task Item.");
//                    count = 0;
//                    completionBool = true;
//                }
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("There is no Task with that number, please try again.");
//                sc.nextLine();
//                completionBool = true;
//                count = 0;
//
//            } catch (InputMismatchException e) {
//                System.out.println("Please only enter a number, try again.");
//                sc.nextLine();
//                completionBool = true;
//                count = 0;
//            }
//        }
//    }
//
//    private String unMarkItem(ArrayList taskListArray, int taskUnMarkNumber) {
//        String finalUnMarkedItem = (String) taskListArray.get(taskUnMarkNumber);
//        finalUnMarkedItem = finalUnMarkedItem.replace("*Completed* ", "");
//        return finalUnMarkedItem;
//    }

}