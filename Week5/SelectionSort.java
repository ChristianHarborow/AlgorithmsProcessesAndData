package arraySorter;

/**
 * An implementation of selection sort
 *
 * @author Christian Harborow
 * @version December 2019
 */
public class SelectionSort<T extends Comparable<? super T>> implements ArraySort<T>{
    /**
     * Sort an array.
     *
     * @param array the array to be sorted.
     * @return the sorted array.
     */
    @Override
    public T[] sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++){

            int max = 0;

            for (int j = 1; j < array.length - i; j++){
                // Find the largest unsorted element
                if (array[j].compareTo(array[max]) > 0){
                    max = j;
                }
            }

            // Swap the largest unsorted element with the last unsorted element
            T swap = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[max];
            array[max] = swap;
        }
        return array;
    }
}