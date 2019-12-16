package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import org.junit.jupiter.api.Test;
import scope.IntegerScope;

public class IntegerQuickSortTest extends QuickSortTest<Integer>{
    @Override
    ArrayGenerator<Integer> getGenerator() {
        return new IntegerArrayGenerator(new IntegerScope());
    }

    @Test
    void testSorted10Thousand(){ testSorted(10000); }

    @Test
    void testSorted50Thousand(){ testSorted(50000); }

    @Test
    void testContents10Thousand(){ testContents(10000); }

    @Test
    void testContents50Thousand(){ testContents(50000); }
}
