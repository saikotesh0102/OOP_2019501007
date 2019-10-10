import java.util.*;

public class Task {
    private String name;
    private String status;
    private Date date;
    private boolean important;
    private boolean urgent;
    
    public Task(final String name, final String status, final Date date, final boolean important, final boolean urgent) {
        this.name = name;
        this.date = new Date();
        if (important) {
            this.important = "Important";
        } else {
            this.important = "Not Important";
        }
        if (urgent) {
            this.urgent = "Urgent";
        } else {
            this.urgent = "Not Urgent";
        }
        this.status = status;

    }

    public void setName(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDate(final Date date){
        this.Date = date;
    }

    public int getDate() {
        return date;
    }

    public void setImportant(final boolean Important){
        if (important) {
            this.important = "Important";
        } else {
            this.important = "Not Important";
        }
    }

    public String getImportant() {
        return important;
    }

    public void setUrgent(final boolean urgent){
        if (urgent) {
            this.urgent = "Urgent";
        } else {
            this.urgent = "Not Urgent";
        }
    }

    public String getUrgent() {
        return urgent;
    }

    public String toString() {
        String str = this.name + ", " + this.timeToComplete + ", " + this.important + ", " + this.urgent + ", " + this.status;
        return str;
    }
}