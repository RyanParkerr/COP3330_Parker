import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskList {
    private List<TaskItem> taskList;

    public TaskList() { taskList = new ArrayList<>(); }

    public int size() { return taskList.size(); }

    public void add(TaskItem taskItem) { taskList.add(taskItem); }

    public void remove(int taskItemNumber) { taskList.remove(taskItemNumber); }

    public TaskItem get (int taskItemNumber) { return taskList.get(taskItemNumber); }

    // the next 4 functions are for JUNIT testing purposes
    public String getTitle(int index) { return this.get(index).getTitle(); }

    public String getDescription(int index) { return this.get(index).getDesc(); }

    public String getDate(int index) { return this.get(index).getDate().toString(); }

    public boolean isComplete(int index) { return this.get(index).isComplete(); }
    // end of JUNIT primary function

    public void complete(int index, boolean completion) { this.get(index).complete(completion); }

    public void update(int index, String title, String description, String date) {
        TaskItem taskItem = new TaskItem(title, description, date);
        taskList.set(index, taskItem);
    }

    public String viewAllTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem taskItem;

        for (int i = 0; i < this.size(); i++) {
            taskItem = this.get(i);
            if(taskItem.isComplete()) {
                sb.append(String.format("-COMPLETED- %d) %s%n", i, taskItem));
            } else {
                sb.append(String.format("%d) %s%n", i, taskItem));
            }
        }
        return sb.toString();
    }

    public String viewCompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem taskItem;

        for (int i = 0; i < this.size(); i++) {
            taskItem = this.get(i);
            if(taskItem.isComplete()) {
                sb.append(String.format("-COMPLETED- %d) %s%n", i, taskItem));
            }
        }
        return sb.toString();
    }

    public String viewUncompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem taskItem;

        for (int i = 0; i < this.size(); i++) {
            taskItem = this.get(i);
            if(!taskItem.isComplete()) {
                sb.append(String.format("%d) %s%n", i, taskItem));
            }
        }
        return sb.toString();
    }

    public boolean isTaskCompleted(int response) {
        TaskItem taskItem;

        taskItem = this.get(response);
        return taskItem.isComplete();
    }

    public void saveList(String fileName) {
        try(Formatter output = new Formatter(fileName)) {
            output.format("taskList\n"); // this identifies if the file is a task list or not
            for (int i = 0; i < taskList.size(); i++) {
                TaskItem taskItem = taskList.get(i);
                if(taskItem.isComplete()) {
                    output.format("complete\n");
                } else {
                    output.format("incomplete\n");
                }
                output.format(taskItem.getTitle() + "\n");
                output.format(taskItem.getDesc() + "\n");
                output.format(taskItem.getDate().toString() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find this File...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadList(String fileName) {
        List <TaskItem> loadedList = taskList;
        taskList = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(fileName));
            String type = input.nextLine();
            if(type.equalsIgnoreCase("TaskList")) {
                while(input.hasNext()) {
                    String completion = input.nextLine();
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String date = input.nextLine();

                    TaskItem taskItem = new TaskItem(title, description, date);
                    taskItem.complete(completion.equals("complete"));
                    this.add(taskItem);
                }
            } else {
                taskList = loadedList;
                throw new InputMismatchException("Filename entered is invalid.");
            }
        } catch (FileNotFoundException ex) {
            taskList = loadedList;
            throw new InputMismatchException("There are no files with that name.");

        } catch (NoSuchElementException ex) {
            taskList = loadedList;
            throw new InputMismatchException("This file is not a valid task list.");
        }
    }
}
