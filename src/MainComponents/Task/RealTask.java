package MainComponents.Task;

import Secondary.ConsoleColors;
import Secondary.Priority;

public class RealTask extends Task {

    public RealTask(String id, int creationTime, int executionTime, Priority priority) {
        super(id, creationTime, executionTime, priority);
    }

    @Override
    public String getId() {
        return ConsoleColors.GREEN + id + ConsoleColors.RESET;
    }

    @Override
    public int compareTo(Task o) {
        if (this.getPriority() != o.getPriority()) {
            if (this.getPriority() == Priority.HIGH) {
                return -1;
            } else {
                return 1;
            }
        }
        return o.getExecutionTime() - this.getExecutionTime();
    }

    @Override
    public String toString() {
        return ConsoleColors.GREEN + id + ConsoleColors.RESET;
    }
}