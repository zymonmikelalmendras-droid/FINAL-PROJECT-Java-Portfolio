package model;

public class Task extends AbstractTask {
    private String status;

    public Task(int taskId, String taskName, String taskDescription, String status) {
        super(taskId, taskName, taskDescription);
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}