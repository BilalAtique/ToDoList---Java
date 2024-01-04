import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Task {
    private String date;
    private String time;
    private String taskDesc;
    private String status;

    Task(String date, String time, String taskDesc, String status) {
        this.date = date;
        this.time = time;
        this.taskDesc = taskDesc;
        this.status = status;
    }

    Task() {

    }

    public void updateDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void updateTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void updateTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
