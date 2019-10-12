import java.text.*;

public final class TestTasks {

    public static void main(final String[] args) throws ParseException {
        ToDoList obj = new ToDoList();
    
        Task t1 = new Task("Task1 Assignment-1 27/09/2019 pending");
        Task t2 = new Task("Task2 Assignment-2 24/09/2019 incomplete");
        Task t3 = new Task("Task3 Assignment-3 29/09/2019 inprocess");
    
        obj.addTask(t1);
        obj.addTask(t2);
        obj.addTask(t3);
        obj.displayAllTasks();
        obj.displayOverdueTasks();
        obj.displayPendingTasks();
        obj.searchByTaskName("Task1");
        obj.removeTask("Task2");
        obj.displayTasksByDate("24/09/2019");
        obj.updateTask(t3, "Due Date", "30/09/2019");
        obj.updateTask(t1, "description", "Library Card");
        obj.displayTasksByDate("24/09/2019");
        obj.displayAllTasks();
    }
}
