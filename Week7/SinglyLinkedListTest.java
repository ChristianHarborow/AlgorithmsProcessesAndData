import arrayGenerator.generator.IntegerArrayGenerator;
import arrayGenerator.scope.IntegerScope;
import linkedList.list.ListAccessError;
import linkedList.list.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    private void writeReadTest(int size) throws ListAccessError {
        IntegerArrayGenerator generator = new IntegerArrayGenerator(new IntegerScope());
        Integer[] testData = generator.getArray(size);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < testData.length; i++){
            list.add(i, testData[i]);
        }

        for (int i = 0; i < testData.length; i++){
            if (!(list.get(i).equals(testData[i]))){
                fail();
            }
        }
    }

    private void removeOrderRetentionTest(int size, int index) throws ListAccessError{
        IntegerArrayGenerator generator = new IntegerArrayGenerator(new IntegerScope());
        Integer[] testDataArray = generator.getArray(size);
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(testDataArray));
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < testData.size(); i++){
            list.add(i, testDataArray[i]);
        }
        
        list.remove(index);
        testData.remove(index);

        for (int i = 0; i < testData.size(); i++){
            if (!(list.get(i).equals(testData.get(i)))){
                fail();
            }
        }
    }

    private void addOrderRetentionTest(int size, int index, int value) throws ListAccessError{
        IntegerArrayGenerator generator = new IntegerArrayGenerator(new IntegerScope());
        Integer[] testDataArray = generator.getArray(size);
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(testDataArray));
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < testData.size(); i++){
            list.add(i, testDataArray[i]);
        }

        list.add(index, value);
        testData.add(index, value);

        for (int i = 0; i < testData.size(); i++){
            if (!(list.get(i).equals(testData.get(i)))){
                fail();
            }
        }
    }

    @Test
    void writeReadTest10() throws ListAccessError{ writeReadTest(10); }

    @Test
    void writeReadTest100() throws ListAccessError{ writeReadTest(100); }

    @Test
    void writeReadTest1000() throws ListAccessError{ writeReadTest(1000); }

    @Test
    void removeOrderRetentionTest10() throws ListAccessError{ removeOrderRetentionTest(10, 4); }

    @Test
    void removeOrderRetentionTest100() throws ListAccessError{ removeOrderRetentionTest(100, 23); }

    @Test
    void removeOrderRetentionTest1000() throws ListAccessError{ removeOrderRetentionTest(1000, 327); }

    @Test
    void addOrderRetentionTest10() throws ListAccessError{ addOrderRetentionTest(10, 6, 23); }

    @Test
    void addOrderRetentionTest100() throws ListAccessError{ addOrderRetentionTest(100, 72, 15); }

    @Test
    void addOrderRetentionTest1000() throws ListAccessError{ addOrderRetentionTest(1000, 556, 99); }
}