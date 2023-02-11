package MainComponents.Task;

import Secondary.ConsoleColors;
import Secondary.Priority;

public class NullTask extends Task {
    public NullTask() {
        super(" X", 0, 0, Priority.LOW);
        this.isCompleted = true;
    }

    @Override
    public String getId() {
        return ConsoleColors.RED + id + ConsoleColors.RESET;
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }

    @Override
    public String toString() {
        return ConsoleColors.RED + id + ConsoleColors.RESET;
    }
}