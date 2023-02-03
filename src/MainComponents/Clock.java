package MainComponents;

import MainComponents.Task.Task;
import Secondary.ConsoleColors;

import java.util.ArrayList;

public class Clock {
    private final int ClockCycleNumber;
    private final ArrayList<Task> tasksCreated;
    private String id;

    public Clock(int ClockCycleNumber) {
        this.ClockCycleNumber = ClockCycleNumber;
        this.id = "C" + ClockCycleNumber;
        this.tasksCreated = new ArrayList<>();
    }

    public String getId() {
        return ConsoleColors.YELLOW + id + ConsoleColors.RESET;
    }

    public int getCycleNumber() {
        return ClockCycleNumber;
    }

    public ArrayList<Task> getTasksCreated() {
        return tasksCreated;
    }


    public void addTask(Task task) {
        tasksCreated.add(task);
    }
}