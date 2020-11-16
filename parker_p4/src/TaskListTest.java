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

    @Test
    void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
        TaskItem editedTask = new TaskItem("Title", "2020-04-25", "New Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        taskList.edit(0, editedTask);
        assertEquals(taskList.get(0), editedTask);
    }

    @Test
    void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
        TaskItem editedTask = new TaskItem("New Title", "2020-04-25", "Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        taskList.edit(0, editedTask);
        assertEquals(taskList.get(0), editedTask);
    }

    @Test
    void removingTaskItemsDecreasesSize() {
        TaskItem task = new TaskItem("Title", "2021-10-11", "Description");
        TaskList taskList = new TaskList();
        taskList.add(task);
        int originalSize = taskList.size();
        taskList.remove(0);
        assertEquals(originalSize - 1, taskList.size());
    }
}