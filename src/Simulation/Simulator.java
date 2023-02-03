package Simulation;

import MainComponents.Clock;
import Collections.ProcessorsCollection;
import MainComponents.Task.RealTask;
import MainComponents.Task.Task;
import Collections.TimeLine;
import Secondary.Priority;
import Secondary.Recorder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
    private Scheduler scheduler;
    private File file;
    private int processorsNumber, totalClockCycles, tasksNumber;
    private ProcessorsCollection processorsCollection = ProcessorsCollection.getInstance();
    private Recorder recorder;
    private ArrayList<Task> allTasks;
    private TimeLine timeLine;

    public Simulator() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the path of input file: ");
        file = new File(scn.nextLine());
        scn.close();

        readInput(file);
        timeLine = new TimeLine(totalClockCycles, allTasks);
        recorder = new Recorder(processorsNumber, totalClockCycles, timeLine);
        scheduler = new Scheduler(recorder);

        processorsCollection.initializeKProcessors(processorsNumber);
        System.out.println();
    }

    public void readInput(File file) {
        allTasks = new ArrayList<>();

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        processorsNumber = sc.nextInt();
        totalClockCycles = sc.nextInt();
        tasksNumber = sc.nextInt();


        for (int i = 1; i <= tasksNumber; i++) {
            int creationTime = sc.nextInt(), executionTime = sc.nextInt(), priority = sc.nextInt();
            Priority currentPriority = (priority == 1 ? Priority.HIGH : Priority.LOW);
            allTasks.add(new RealTask("T" + i, creationTime, executionTime, currentPriority));
        }
    }

    public void run() {
        System.out.println("Processing has started ... ");
        for (Clock clock : timeLine) {
            scheduler.scheduleTasks(clock);
            System.out.println("After the " + clock.getId() + " clock");
            processorsCollection.printProcessorsState(clock);
            System.out.println("\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // print the final report
        recorder.print();
    }

}
