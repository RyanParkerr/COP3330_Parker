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

    }

//    @Test
//    public void completingTaskItemFailsWithInvalidIndex() {
//
//    }

//    editingItemDescriptionFailsWithInvalidIndex()
//    editingItemDescriptionSucceedsWithExpectedValue()
//    editingItemDueDateSucceedsWithExpectedValue()
//    editingItemTitleFailsWithEmptyString()
//    editingItemTitleFailsWithInvalidIndex()
//    editingItemTitleSucceedsWithExpectedValue()
//    editingTaskItemDueDateFailsWithInvalidDateFormat()
//    editingTaskItemDueDateFailsWithInvalidIndex()
//    editingTaskItemDueDateFailsWithInvalidYYYMMDD()
//    gettingItemDescriptionFailsWithInvalidIndex()
//    gettingItemDescriptionSucceedsWithValidIndex()
//    gettingItemDueDateFailsWithInvalidIndex()
//    gettingItemDueDateSucceedsWithValidIndex()
//    gettingItemTitleFailsWithInvalidIndex()
//    gettingItemTitleSucceedsWithValidIndex()
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
    
//    removingItemsFailsWithInvalidIndex()
//    savedTaskListCanBeLoaded()
//    uncompletingTaskItemChangesStatus()
//    uncompletingTaskItemFailsWithInvalidIndex()

}