package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import timer.Timer;

public class CleverSearcherTimer extends CleverSearcher implements Timer {
    private int k;

    private CleverSearcherTimer(int[] array, int k) {
        super(array, k);
        this.k = k;
    }

    /**
     * We are timing CleverSearchers.
     *
     * @param size the size of the task to be timed.
     * @return a CleverSearcher of the required size.
     */
    @Override
    public Timer getTimer(int size) {
        ArrayGenerator generator = new CleverRandomListingGenerator(size);
        return new CleverSearcherTimer(generator.getArray(), k);
    }

    /**
     * We are timing the findElement() method.
     */
    @Override
    public void timedMethod() {
        try {
            findElement();
        }
        catch (IndexingError indexingError) {
            //shouldn't trigger
        }
    }

    /**
     * Cease timing when the runtime exceeds 10 seconds.
     *
     * @return 10 seconds as the maximum runbtime.
     */
    @Override
    public long getMaximumRuntime() {
        return 10;
    }

    /**
     * Minimum task size (array size) is set to 1 million.
     * @return minimum task size of 1 million
     */
    @Override
    public int getMinimumTaskSize() {
        return 1000000;
    }

    /**
     * Cease timing when the array size exceeds 100 million
     *
     * @return 100 million as the maximum array size.
     */
    @Override
    public int getMaximumTaskSize() {
        return 100000000;
    }

    /**
     * Run the sequence of timings specified by the methods above.
     *
     * @param args not usually used
     * @throws IndexingError should not happen
     */
    public static void main(String[] args) throws IndexingError {
        CleverSearcherTimer timer1 = new CleverSearcherTimer(null, 5);
        CleverSearcherTimer timer2 = new CleverSearcherTimer(null, 20000);
        timer1.timingSequence();
        System.out.println("\nStarting next timer\n");
        timer2.timingSequence();
    }
}
