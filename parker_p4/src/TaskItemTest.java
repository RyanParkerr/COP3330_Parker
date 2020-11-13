import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("Title", "April 25, 2020", "Description"));
    }

    @Test
    void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "2001-04-25", "Description"));
    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("Title", "2001-04-25", "Description"));
    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("Title", "2001-04-25", "Description"));
    }
//
//    @Test
//    void settingTaskItemDueDateFailsWithInvalidDate() {
//        TaskItem item = new setDueDate();
//    }
//
//    @Test
//    void settingTaskItemDueDateSucceedsWithValidDate() {
//        TaskItem item = new setDueDate();
//    }
//
//    @Test
//    void settingTaskItemTitleFailsWithInvalidTitle() {
//        TaskItem item = new setTitle();
//    }
//
//    @Test
//    void settingTaskItemTitleSucceedsWithValidTitle() {
//        TaskItem item = new setTitle();
//    }
}