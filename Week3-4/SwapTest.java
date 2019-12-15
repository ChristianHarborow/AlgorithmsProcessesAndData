package genericMethods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SwapTest {

    private void swapIntegersTest(int indexOne, int indexTwo){
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int startValueOne = array[indexOne];
        int startValueTwo = array[indexTwo];
        Swap.swap(array, indexOne, indexTwo);
        assertTrue(startValueOne == array[indexTwo] && startValueTwo == array[indexOne]);
    }

    private void swapStringsTest(int indexOne, int indexTwo){
        String[] array = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String startValueOne = array[indexOne];
        String startValueTwo = array[indexTwo];
        Swap.swap(array, indexOne, indexTwo);
        assertTrue(startValueOne.equals(array[indexTwo]) && startValueTwo.equals(array[indexOne]));
    }

    private void outOfBoundsTest(int indexOne, int indexTwo){
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThrows(IndexOutOfBoundsException.class, ()->Swap.swap(array, -1, 3));
    }

    @Test 
    void testIntegerSwap1(){ swapIntegersTest(1, 5); }

    @Test
    void testIntegerSwap2(){ swapIntegersTest(2, 8); }

    @Test
    void testIntegerSwap3(){ swapIntegersTest(6, 3); }

    @Test
    void testStringSwap1(){ swapStringsTest(2, 5); }

    @Test
    void testStringSwap2(){ swapStringsTest(6, 8); }

    @Test
    void testStringSwap3(){ swapStringsTest(1, 3); }

    @Test
    void testOutOfBounds1(){ outOfBoundsTest(-1, 5); }

    @Test
    void testOutOfBounds2(){ outOfBoundsTest(-5, 3); }

    @Test
    void testOutOfBounds3(){ outOfBoundsTest(3, 10); }

    @Test
    void testOutOfBounds4(){ outOfBoundsTest(7, 12); }
}