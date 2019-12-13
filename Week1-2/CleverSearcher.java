package searcher;

import java.util.Arrays;
/**
 * Implements the find (kth) element method by using a sorted helper array of size k to go through
 * the whole array, comparing its elements to those of the helper array, replacing and resorting if
 * larger, then returning element 0 of the helper array
 *
 * @author Christian Harborow
 * @version December 2019
 *
 */
public class CleverSearcher extends Searcher{
    private int[] helperArray;

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    /**
     * Find the kth largest element in an array of ints using a helper array
     *
     * <ul>
     *      <li> Create, fill and sort helper array </li>
     *      <li> Compare array elements to helper array elements </li>
     *      <li> Replace and resort helper array elements with larger array elements </li>
     *      <li> Return element 0 of helper array </li>
     * </ul>
     *
     * @return kth largest element of array
     * @throws IndexingError if the index, k, is out of bounds
     */
    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = getIndex();

        if (k <= 0 || k > array.length) {
            throw new IndexingError();
        }

        helperArray = new int[k];
        System.arraycopy(array, 0, helperArray, 0, k);
        Arrays.sort(helperArray);

        for (int i = k; i < array.length; i++){
            if (array[i] > helperArray[0]){
                placeElement(array[i]);
            }
        }

        return helperArray[0];
    }

    /**
     * Replaces one of the elements of the helper array with a new element
     * whilst retaining the arrays order
     * @param element the new element to be placed
     */
    private void placeElement(int element){
        helperArray[0] = element;
        for (int i = 1; i < getIndex(); i++){
            if (element > helperArray[i]){
                helperArray[i - 1] = helperArray[i];
                helperArray[i] = element;
            }
        }
    }
}