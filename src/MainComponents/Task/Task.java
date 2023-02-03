package MainComponents.Task;

import Secondary.Priority;

public abstract class Task implements Comparable<Task> {
    protected String id;
    protected int creationTime;
    protected int executionTime;
    protected Priority priority;
    protected boolean isCompleted;

    public Task(String id, int creationTime, int executionTime, Priority priority) {
        this.id = id;
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
        this.isCompleted = false;
    }

    public int getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(int creationTime) {
        this.creationTime = creationTime;
    }


    abstract public String getId();

    public void setId(String id) {
        this.id = id;
    }

    public int getExecutionTime() {
        return executionTime;
    }


    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    public void completeTask() {
        this.isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public abstract String toString();
}