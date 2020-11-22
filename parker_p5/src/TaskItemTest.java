import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "Description", "April, 25, 2001"));
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "Description", "2020-04-10"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-04-25"));
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-04-25"));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertDoesNotThrow(() -> taskList.update(0, "New Title", "New Description", "2020-04-01"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertThrows(TaskItem.InvalidDateException.class, () -> taskList.update(0, "New Title", "New Description", "April 25, 2020"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertThrows(TaskItem.InvalidDateException.class, () -> taskList.update(0, "New Title", "New Description", "2020-99-52"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertDoesNotThrow(() -> taskList.update(0, "New Title", "New Description", "2020-04-01"));
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertThrows(TaskItem.InvalidTitleException.class, () -> taskList.update(0, "", "New Description", "2020-04-01"));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskList taskList = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2020-04-25");
        taskList.add(task);

        assertDoesNotThrow(() -> taskList.update(0, "New Title", "New Description", "2020-04-01"));
    }
}