package MainComponents;

import Secondary.ConsoleColors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProcessorsCollection implements Iterable<Processor> {
    private static ProcessorsCollection soloInstance = new ProcessorsCollection();
    private ArrayList<Processor> collection = new ArrayList<>();

    private ProcessorsCollection() {
    }

    public static ProcessorsCollection getInstance() {
        return soloInstance;
    }


    public void addProcessor(Processor processor) {
        collection.add(processor);
    }

    @Override
    public Iterator<Processor> iterator() {
        return new ProcessorsCollectionIterator();
    }

    public void printProcessorsState(Clock clock) {
        for (Processor processor : collection) {
            System.out.print(processor);
            if (processor.isAvailable(clock)) {
                System.out.println(" has no assigned tasks.");
            } else {
                System.out.println(" will be working on the " + processor.getAssignedTask() + " until " +
                        "the end of " + ConsoleColors.YELLOW + "C" +
                        (processor.getUpcomingAvailability() - 1) + ConsoleColors.RESET + " clock.");
            }
        }
    }

    public void initializeKProcessors(int k) {
        for (int i = 1; i <= k; i++) {
            addProcessor(new Processor("P" + (i)));
        }
    }

    class ProcessorsCollectionIterator implements Iterator<Processor> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < collection.size();
        }

        @Override
        public Processor next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return collection.get(index++);
        }
    }
}
