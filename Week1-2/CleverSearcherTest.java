package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Christian Harborow
 * @version December 2019
 */
public class CleverSearcherTest extends SearcherTest{
    @Override
    protected Searcher createSearcher(int[] array, int index){
        return new CleverSearcher(array, index);
    }

    /**
     * Test that the searcher handles invalid indexes correctly.
     * 
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param index the index (invalid indexes are less than or equal to 0 or greater than the array size)
     */
    private void outOfBoundsTest(int arraySize,int index){
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);
        Searcher search = createSearcher(generator.getArray(), index);
        assertThrows(IndexingError.class, search::findElement);
    }

    @Test
    void test0In10(){
        outOfBoundsTest(10, 0);
    }

    @Test
    void testMinus5In100(){
        outOfBoundsTest(100, -5);
    }

    @Test
    void test1001In1000(){
        outOfBoundsTest(1000, 1001);
    }

    @Test
    void test15000In10000(){
        outOfBoundsTest(10000, 15000);
    }
}
