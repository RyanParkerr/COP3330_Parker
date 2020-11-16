import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    void creatingTaskItemFailsWithInvalidDueDate1() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "April 25, 2020", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate2() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "YYYY-MM-DD", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate3() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "2020-12 12", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate4() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate5() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "2020-06-04 ", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate6() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "2000-06-04", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate7() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "2020-28-04", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidDueDate8() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "2020-11-60", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "2001-04-25", "Description"));
    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("Title", "2020-04-25", "Description"));
    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("Title", "2020-04-25", "Description"));
    }
}