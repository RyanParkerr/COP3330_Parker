import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    @Test
    public void addingItemsIncreasesSize() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);
        assertEquals(1, taskList.size());
    }
    @Test
    public void completingTaskItemChangesStatus() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        TaskItem taskItem = taskList.get(0);
        boolean status = taskItem.isComplete();
        taskList.complete(0, true);
        assertTrue(taskList.isTaskCompleted(0));
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.complete(10, true));
    }
    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.update(10, "Title", "New Description", "2020-04-25"));
    }
    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertDoesNotThrow(() -> taskList.update(0, "Title", "New Description", "2020-04-25"));
    }
    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertDoesNotThrow(() -> taskList.update(0, "New Title", "Description", "2021-10-10"));
    }
    @Test
    public void editingItemTitleFailsWithEmptyString() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(TaskItem.InvalidTitleException.class, () -> taskList.update(0, "", "Description", "2020-04-25"));
    }
    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.update(10, "New Title", "Description", "2020-04-25"));
    }
    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertDoesNotThrow(() -> taskList.update(0, "New Title", "Description", "2020-04-25"));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(TaskItem.InvalidDateException.class, () -> taskList.update(0, "Title", "Description", "April 25, 2020"));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.update(10, "New Title", "Description", "2021-10-10"));
    }
    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertThrows(TaskItem.InvalidDateException.class, () -> taskList.update(0, "New Title", "New Description", "2020-99-52"));
    }
    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.getDescription(10));
    }
    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertDoesNotThrow(() -> taskList.getDescription(0));
    }
    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.getDate(10));
    }
    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertDoesNotThrow(() -> taskList.getDate(0));
    }
    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.getTitle(10));
    }
    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertDoesNotThrow(() -> taskList.getTitle(0));
    }
    @Test
    public void newListIsEmpty() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.size());
    }
    @Test
    public void removingItemsDecreasesSize() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);
        int tempVal = taskList.size();
        taskList.remove(0);
        assertEquals(tempVal - 1, taskList.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.remove(10));
    }
    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList taskListSaved = new TaskList();
        TaskList taskListLoaded = new TaskList();
        TaskItem taskItem = new TaskItem("title", "description", "2020-04-10");
        taskListSaved.add(taskItem);
        taskListSaved.saveList("taskTestFile");

        taskListLoaded.loadList("taskTestFile");

        assertEquals(taskListSaved.viewAllTasks(), taskListLoaded.viewAllTasks());
    }
    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        TaskItem taskItem = taskList.get(0);
        taskList.complete(0, true);
        boolean status = taskItem.isComplete();
        taskList.complete(0, false);
        assertFalse(taskList.isTaskCompleted(0));
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList taskList = new TaskList();
        taskList.add(new TaskItem("Title", "Description", "2020-04-25"));
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.complete(10, false));
    }

}