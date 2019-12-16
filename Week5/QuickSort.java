package arraySorter;

/**
 * An implementation of quick sort
 *
 * @author Christian Harborow
 * @version December 2019
 */
public class QuickSort<T extends Comparable<? super T>> implements ArraySort<T>{
    /**
     * Sort an array.
     *
     * @param array the array to be sorted.
     * @return the sorted array.
     */
    @Override
    public T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return  array;
    }

    /**
     * Performs quick sort recursively.
     *
     * @param array the array to be sorted.
     * @param start starting index of the sub-list.
     * @param end ending index of the sub-list.
     */
    private void quickSort(T[] array, int start, int end){
        if  (start < end) { // if there can be unsorted sub-lists sort them
            int pivotIndex = split(array, start, end); // split list into sorted sub-lists
            quickSort(array, start, pivotIndex - 1); // sort low sub-list
            quickSort(array, pivotIndex + 1, end); // sort high sub-list
        }
    }

    /**
     * Splits a list into two sub-lists using quick sort algorithm.
     *
     * @param array the array to be sorted.
     * @param start starting index of the sub-list.
     * @param end ending index of the sub-list.
     * @return the index of the pivot.
     */
    private int split(T[] array, int start, int end){
        //last element is pivot so end = pivot index
        int lowIndex = end; // looks for elements lower than pivot
        int highIndex = start; // looks for elements larger than pivot

        while (highIndex <= lowIndex){ // if the high and low pointers have not crossed continue loop
            if (array[highIndex].compareTo(array[end]) > 0 &&
                    array[lowIndex].compareTo(array[end]) < 0){
                // if both low and high pointers have found an element swap them
                T swap = array[lowIndex];
                array[lowIndex] = array[highIndex];
                array[highIndex] = swap;
                lowIndex--;
                highIndex++;
            }
            else if (array[highIndex].compareTo(array[end]) > 0){
                // if the low pointer hasn't found an element decrease its index by 1
                lowIndex--;
            }
            else if(array[lowIndex].compareTo(array[end]) < 0){
                // if the high pointer hasn't found an element increase its index by 1
                highIndex++;
            }
            else {
                // if neither pointer has found an element decrease the low index by 1
                // and increase the high index by 1
                lowIndex--;
                highIndex++;
            }
        }

        // if the high and low pointers have crossed swap the high index's element with the pivot index's element
        T swap = array[end];
        array[end] = array[highIndex];
        array[highIndex] = swap;
        return highIndex; // returns pivot's sorted position
    }
}