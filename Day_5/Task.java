public class Task {
    private String title;
    private String assignedTo;
    private String status;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    
    public void Task(final String title, final String assignedTo, final String status, final int timeToComplete, final boolean important, final boolean urgent) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
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

    public void setTitle(final String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAssignedTo(final String assignedTo){
        this.assignedTo = assignedTo;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTimeToComplete(final int timeToComplete){
        this.timeToComplete = timeToComplete;
    }

    public int getTimeToComplete() {
        return timeToComplete;
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
        String str = this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " + this.important + ", " + this.urgent + ", " + this.status;
        return str;
    }
}