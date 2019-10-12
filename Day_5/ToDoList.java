import java.util.*;
import java.text.*;
import java.time.*;

public final class ToDoList {

    private Task[] tasks;
    private int taskIndex;

    public ToDoList() {
        final int capacity = 10;
        this.tasks = new Task[capacity];
        this.taskIndex = 0;
    }

    public void resize() {
        Task[] temp = new Task[taskIndex * 2];
        for (int index = 0; index < taskIndex; index++) {
            temp[index] = tasks[index];
        }
        tasks = temp;
        temp = null;
    }

    public void addTask(final Task obj) {
        if (taskIndex == tasks.length) {
            resize();
        }
        tasks[taskIndex] = obj;
        taskIndex += 1;
    }

    public void removeTask(final String str) {
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i].getTaskName().equals(str)) {
                for (int j = i + 1; j < taskIndex; j++) {
                    tasks[i] = tasks[j];
                    i++;

                }
                tasks[taskIndex] = null;
                taskIndex--;
            }
        }   
    }

    public void switchUp(final String field, final int i, final String str) throws ParseException {
        switch (field) {
            case "Task Name": case "task name" :
            tasks[i].setTaskName(str);
            break;

            case "Description": case "description":
            tasks[i].setTaskDescription(str);
            break;
            
            case "Due Date": case "due date": {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
            tasks[i].setDate(date);
            break;
            }
        
            case "Status": case "status":
            tasks[i].setStatus(str);
            break;
            
            default:
            System.out.println("No such Field");
            break;

        }
    }

    public void updateTask(final Task task, final String field, final String str) throws ParseException {
        for (int index = 0; index < taskIndex; index++) {
            if (tasks[index] == task) {
                switchUp(field, index, str);
            }
        }
    }


    public void displayPendingTasks() {
        for (int index = 0; index < taskIndex; index++) {
            if (tasks[index].getStatus().equals("incomplete")) {
                System.out.println(tasks[index]);
            }
        }
    }

    public void displayTasksByDate(final String d) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
        for (int index = 0; index < taskIndex; index++) {
            if (tasks[index].getDate().equals(date)) {
                System.out.println(tasks[index]);
            }
        }
    }

    public Task searchByTaskName(final String taskName) {
        for (int index = 0; index < taskIndex; index++) {
            if (tasks[index].getTaskName().equals(taskName)) {
               System.out.println(tasks[index]);
            }
        }
        return null;
    }

    public void displayOverdueTasks() {
        LocalDate now = LocalDate.now();
        int previousMonth = now.getMonthValue();
        int previousYear = now.getYear();
        for (int index = 0; index < taskIndex; index++) {
            final int yearConst = 1900;
            final int monthConst = 1;
            int month = tasks[index].getDate().getMonth() + monthConst;
            int year = tasks[index].getDate().getYear() + yearConst;
            int difference = now.getDayOfMonth() - tasks[index].getDate().getDate();
            if (month == previousMonth && year == previousYear && difference > 0 && (tasks[index].getStatus().equals("incomplete") || tasks[index].getStatus().equals("pending"))) {
                System.out.println(tasks[index]);
            }
        }
    }

    public void displayAllTasks() {
        for (int i = 0; i < taskIndex; i++) {
            System.out.println(tasks[i]);
        }
    }
}
