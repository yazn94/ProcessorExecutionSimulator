package MainComponents;

import MainComponents.Task.NullTask;
import MainComponents.Task.Task;
import Secondary.ConsoleColors;
public class Processor {
    private int upcomingAvailability;
    private String id;
    private Task assignedTask;

    public Processor(String id) {
        this.id = id;
        upcomingAvailability = 0;
        assignedTask = new NullTask();
    }

    public boolean isAvailable(Clock currentClock) {
        return upcomingAvailability <= currentClock.getCycleNumber();
    }

    public void assignTask(Task task, Clock clock) {
        if (!(assignedTask instanceof NullTask)) {
            assignedTask.completeTask();
        }
        assignedTask = task;
        upcomingAvailability = clock.getCycleNumber() + task.getExecutionTime();
    }

    public Task getAssignedTask() {
        return assignedTask;
    }

    public int getUpcomingAvailability() {
        return upcomingAvailability;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLUE + id + ConsoleColors.RESET;
    }

    public String getId() {
        return ConsoleColors.BLUE + id + ConsoleColors.RESET;
    }
}