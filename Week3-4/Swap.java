package genericMethods;
/**
 * This class defines a generic static method that will swap two given elements
 * of an array.
 *
 * @author Christian Harborow
 * @version December 2019
 */
public class Swap {

    /**
     * Swap two elements in an array
     * @param <T> the type of objects to be swapped
     * @param array the array in which elements will be swapped
     * @param indexOne the index of the first element to be swapped
     * @param indexTwo the index of the second element to be swapped
     */
    public static <T> void swap(T[] array, int indexOne, int indexTwo) throws IndexOutOfBoundsException{
        if (indexOne < 0 || indexOne >= array.length) throw new IndexOutOfBoundsException("indexOne out of bounds");
        if (indexTwo < 0 || indexTwo >= array.length) throw new IndexOutOfBoundsException("indexTwo out of bounds");

        T element = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = element;
    }
}