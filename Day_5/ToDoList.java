import java.util.*;

public class ToDoList {

    public Task[] tasks;
    int index; 

    public ToDoList() {
        tasks = new Task[10];
        index = 0;
    }

    public void addTask(final Task task) {
        tasks[index] = task;
        index++;
    }

    // public String toString() {
    //     String str = "";
    //     for (Task t : tasks) {
    //         Str += t;
    //         Str += "\n";
    //     }
    //     return m;
    // }

    public Task getNextTask(final String nextTask) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(nextTask)) {
                if (tasks[i].getStatus().equals("todo")) {
                    if (tasks[i].getImportant().equals("Important") && tasks[i].getUrgent().equals("Not Urgent")) {
                        return tasks[i];
                    }
                }
            }
        }

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(nextTask)) {
                if (tasks[i].getStatus().equals("todo")) {
                    if (tasks[i].getImportant().equals("Important") && tasks[i].getUrgent().equals("Urgent")) {
                        return tasks[i];
                    }
                }
            }
        }
        return null;
    }
    
    public Task[] getNextTask(final String nextTask, final int count) {
        Task[] tas = new Task[count];
        int temp = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(nextTask)) {
                if (tasks[i].getStatus().equals("todo")) {
                    if (tasks[i].getImportant().equals("Important") && tasks[i].getUrgent().equals("Not Urgent")) {
                        if (temp < count) {
                            tas[temp++] = tasks[i];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(nextTask)) {
                if (tasks[i].getStatus().equals("todo")) {
                    if (tasks[i].getImportant().equals("Important") && tasks[i].getUrgent().equals("Urgent")) {
                        if (temp < count) {
                            tas[temp++] = tasks[i];
                        }
                    }
                }
            }
        }
        return tas;
    }
    
    public int totalTimeForCompletion() {
        int count = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getStatus().equals("todo")) {
                count += tasks[i].getDate();
            }
        }
        return count;
    }

    // public static void main(String[] args) {
    //     Task firstTask = new Task();
    //     firstTask.setName() = ("Module 5 Assignment 1");
    //     firstTask.setStatus() = ("InComplete");
    //     firstTask.setDate() = 24/09/2019 ;

    //     Task secondTask = new Task();
    //     secondTask.setName() = ("Module 5 Assignment 1 Date Objects");
    //     secondTask.setStatus() = ("InComplete");
    //     secondTask.setDate() = 23/09/2019 ;

    //     Task thirdTask = new Task();
    //     thirdTask.setName() = ("Module 4 Assignment 1 Library Card Catalog");
    //     thirdTask.setStatus() = ("InProcess");
    //     thirdTask.setDate() = 23/09/2019 ;

    //     ToDoList addTask = new ToDoList();
    //     addTask.addTask(firstTask);
    //     addTask.addTask(secondTask);
    //     addTask.addTask(thirdTask);
    //     addTask.printtasks();
    // }
}
