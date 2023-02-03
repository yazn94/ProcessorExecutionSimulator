package Collections;

import MainComponents.Clock;
import MainComponents.Task.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TimeLine implements Iterable<Clock> {
    private ArrayList<Clock> clocks = new ArrayList<>();

    public TimeLine(int numberOfClocks, ArrayList<Task> tasks) {
        for (int i = 1; i <= numberOfClocks; i++) {
            clocks.add(new Clock(i));
        }

        for (Task task : tasks) {
            clocks.get(task.getCreationTime() - 1).addTask(task);
        }

    }

    public Clock get(int index) {
        return clocks.get(index);
    }

    public void setClock(int index, Clock clock) {
        clocks.set(index, clock);
    }

    public int size() {
        return clocks.size();
    }

    @Override
    public Iterator<Clock> iterator() {
        return new ClocksIterator();
    }

    class ClocksIterator implements Iterator<Clock> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < clocks.size();
        }

        @Override
        public Clock next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return clocks.get(index++);
        }
    }
}
