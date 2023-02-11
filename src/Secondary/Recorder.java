package Secondary;

import MainComponents.Clock;
import MainComponents.Processor;
import Collections.ProcessorsCollection;
import MainComponents.Task.Task;
import Collections.TimeLine;

import java.util.HashMap;


public class Recorder {
    // For each clock cycle, we store a HashMap of the tasks assigned to each processor.
    private final HashMap<Clock, HashMap<Processor, Task>> storedInfo = new HashMap<>();
    private final int processorsNumber;
    private final int totalClockCycles;
    private ProcessorsCollection processorsCollection = ProcessorsCollection.getInstance();
    private TimeLine timeLine;

    public Recorder(int processorsNumber, int totalClockCycles, TimeLine timeLine) {
        this.processorsNumber = processorsNumber;
        this.totalClockCycles = totalClockCycles;
        for (Clock clock : timeLine) {
            storedInfo.put(clock, new HashMap<>());
        }
        this.timeLine = timeLine;
    }

    public void assignTaskToProcessor(Clock clock, Processor processor, Task task) {
        storedInfo.get(clock).put(processor, task);
    }

    public void print() {
        System.out.println("This is the final report, it's a timeline that tells what task each processor was working on" +
                "during each clock cycle : ");

        // Print the header row with the clock cycle numbers
        System.out.print("   | ");
        for (Clock clock : timeLine) {
            System.out.print(String.format("%3s", clock.getId()) + " | ");
        }
        System.out.println();
        for (Processor processor : processorsCollection) {
            System.out.print(String.format("%3s", processor.getId() + " | "));
            for (Clock clock : timeLine) {
                System.out.print(String.format("%3s", storedInfo.get(clock).get(processor).getId()) + " | ");
            }
            System.out.println();
        }
    }


}