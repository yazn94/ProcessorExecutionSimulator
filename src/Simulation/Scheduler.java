package Simulation;

import MainComponents.Clock;
import MainComponents.Processor;
import Collections.ProcessorsCollection;
import MainComponents.Task.NullTask;
import MainComponents.Task.Task;
import Secondary.Recorder;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scheduler {
    private ProcessorsCollection processorsCollection = ProcessorsCollection.getInstance();

    private PriorityQueue<Task> taskQueue = new PriorityQueue<>();
    private Recorder recoder;

    public Scheduler(Recorder recoder) {
        this.recoder = recoder;
    }

    public void scheduleTasks(Clock currentClock) {
        addNewTasksToQueue(currentClock);
        assignTasksToProcessors(currentClock);
    }

    private void assignTasksToProcessors(Clock currentClock) {
        for (Processor processor : processorsCollection) {
            // giving the right task to the processor (might be X)
            if (processor.isAvailable(currentClock)) {
                if (taskQueue.size() > 0) {
                    processor.assignTask(taskQueue.poll(), currentClock);
                    recoder.assignTaskToProcessor(currentClock, processor, processor.getAssignedTask());
                } else {
                    recoder.assignTaskToProcessor(currentClock, processor, new NullTask());
                }
            } else {
                recoder.assignTaskToProcessor(currentClock, processor, processor.getAssignedTask());
            }
        }
    }

    private void addNewTasksToQueue(Clock currentClock) {
        ArrayList<Task> newTasks = currentClock.getTasksCreated();
        taskQueue.addAll(newTasks);
    }
}
