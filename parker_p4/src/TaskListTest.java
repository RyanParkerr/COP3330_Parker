import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListTest {
    @Test
    void addingTaskItemsIncreasesSize() {
        TaskItem task = new TaskItem("Title", "2020-04-25", "Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        assertEquals(1, taskList.size());
    }
//    @Test
//    void completingTaskItemChangesStatus() {
//        TaskItem task = new TaskItem("Title", "2020-04-25", "Description");
//        TaskList taskList = new TaskList();
//        taskList.add(task);
//        taskList.mark(0);
//        assertEquals(1,);
//    }
//
//    @Test
//    void completingTaskItemFailsWithInvalidIndex() {
//        TaskItem task = new TaskItem("Title", "2020-04-25", "Description");
//        TaskList taskList = new TaskList();
//        taskList.add(task);
//        taskList.mark()
//        assertEquals(1, taskList.size());
//    }

    @Test
    void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("Title", "2020-04-25", "Description");
        TaskItem editedTask = new TaskItem("New Title", "2021-04-25", "New Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        taskList.edit(0, editedTask);
        assertEquals(taskList.get(0), editedTask);
    }

    @Test
    void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("Title", "2020-04-25", "Description");
        TaskItem editedTask = new TaskItem("Title", "2020-04-25", "New Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        taskList.edit(0, editedTask);
        assertEquals(taskList.get(0), editedTask);
    }

//    @Test
//    void editingTaskItemDescriptionFailsWithInvalidIndex() {
//
//    }

    @Test
    void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
        TaskItem editedTask = new TaskItem("Title", "2020-04-25", "New Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        taskList.edit(0, editedTask);
        assertEquals(taskList.get(0), editedTask);
    }
//
//    @Test
//    void editingTaskItemDueDateFailsWithInvalidIndex() {
//
//    }

    @Test
    void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
        TaskItem editedTask = new TaskItem("New Title", "2020-04-25", "Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        taskList.edit(0, editedTask);
        assertEquals(taskList.get(0), editedTask);
    }

//    @Test
//    void editingTaskItemTitleFailsWithInvalidIndex() {
//
//    }
//
//    @Test
//    void gettingTaskItemDescriptionFailsWithInvalidIndex() {
//
//    }
//
//    @Test
//    void gettingTaskItemDescriptionSucceedsWithValidIndex() {
//
//    }
//
//    @Test
//    void gettingTaskItemDueDateFailsWithInvalidIndex() {
//
//    }
//
//    @Test
//    void gettingTaskItemDueDateSucceedsWithValidIndex() {
//
//    }
//
//    @Test
//    void gettingTaskItemTitleFailsWithInvalidIndex() {
//
//    }
//
//    @Test
//    void gettingTaskItemTitleSucceedsWithValidIndex() {
//
//    }

//    @Test
//    void newTaskListIsEmpty() {
//        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
//        TaskItem editedTask = new TaskItem("Title", "2020-04-25", "New Description");
//        TaskList taskList = new TaskList();
//        taskList.add(task);
//        taskList.edit(0, editedTask);
//        assertEquals(taskList.get(0), editedTask);
//    }

    @Test
    void removingTaskItemsDecreasesSize() {
        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        int originalSize = taskList.size();
        taskList.remove(0);
        assertEquals(originalSize - 1, taskList.size());
    }

//    @Test
//    void removingTaskItemsFailsWithInvalidIndex() {
//
//    }
//
//    @Test
//    void savedTaskListCanBeLoaded() {
//        TaskList firstTaskList = new TaskList();
//        firstTaskList.add(new TaskItem("Title", "2021-10-11", "Description"));
//        firstTaskList.write("testFile.txt", 0);
//        TaskList loadedTaskList = new TaskList();
//        loadedTaskList.readFile("testFile.txt");
//        assertEquals(firstTaskList.get(0), loadedTaskList.get(0));
//    }

//    @Test
//    void unCompletingTaskItemChangesStatus() {
//
//    }
//
//    @Test
//    void unCompletingTaskItemFailsWithInvalidIndex() {
//
//    }
}