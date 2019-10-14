import java.util.*;
import java.text.*;

public  class Task {

    private String taskName;
    private String taskDescription;
    private Date date;
    private String status;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Task() {

    }

    public Task(final String str) throws ParseException {
        final String[] arr = str.split(" ");
        this.taskName = arr[0];
        this.taskDescription = arr[1];
        this.date = formatter.parse(arr[2]);
        this.status = arr[3];
    }

    public void setTaskName(final String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskDescription(final String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return "{ Task Name = " + this.taskName + ", Task Description = " + this.taskDescription + ", Due Date = " + formatter.format(date) + ", status = " + this.status + " }";
    }
}