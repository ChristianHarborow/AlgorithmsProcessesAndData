import graph.GraphError;
import graph.ReferenceTopologicalSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ReferenceTopologicalSortTesting {
    @Test
    void cyclicErrorTest() throws GraphError {
        ReferenceTopologicalSort<Integer> graph = new ReferenceTopologicalSort<>();

        for (int i = 0; i < 6; i++){
            graph.add(i);
        }

        graph.add(0, 1);
        graph.add(0, 3);
        graph.add(1, 2);
        graph.add(2, 1);
        graph.add(2, 4);
        graph.add(2, 5);
        graph.add(4, 5);
        graph.add(5, 4);

        Assertions.assertThrows(GraphError.class, ()->graph.getSort());
    }

    @Test
    void topologicalSortTest1() throws GraphError {
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(3, 6, 8, 9, 0, 1, 2, 4, 5, 7));
        ReferenceTopologicalSort<Integer> graph = new ReferenceTopologicalSort<>();

        for (int i = 0; i < 10; i++){
            graph.add(i);
        }

        graph.add(0, 1);
        graph.add(0, 5);
        graph.add(1, 7);
        graph.add(3, 2);
        graph.add(3, 4);
        graph.add(3, 8);
        graph.add(6, 0);
        graph.add(6, 1);
        graph.add(6, 2);
        graph.add(8, 4);
        graph.add(8, 7);
        graph.add(9, 4);

        List<Integer> actualResult = graph.getSort();

        for (int i = 0; i < expectedResult.size(); i++){
            if (!expectedResult.get(i).equals(actualResult.get(i))){
                fail();
            }
        }
    }

    @Test
    void topologicalSortTest2() throws GraphError {
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 5, 4, 6));
        ReferenceTopologicalSort<Integer> graph = new ReferenceTopologicalSort<>();

        for (int i = 0; i < 7; i++){
            graph.add(i);
        }

        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(3, 6);
        graph.add(4, 6);
        graph.add(5, 4);
        graph.add(5, 6);

        List<Integer> actualResult = graph.getSort();

        for (int i = 0; i < expectedResult.size(); i++){
            if (!expectedResult.get(i).equals(actualResult.get(i))){
                fail();
            }
        }
    }

    @Test
    void topologicalSortTest3() throws GraphError {
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 2, 6, 3, 4, 5));
        ReferenceTopologicalSort<Integer> graph = new ReferenceTopologicalSort<>();

        for (int i = 0; i < 7; i++){
            graph.add(i);
        }

        graph.add(0, 1);
        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 4);
        graph.add(3, 4);
        graph.add(4, 5);
        graph.add(6, 3);

        List<Integer> actualResult = graph.getSort();

        for (int i = 0; i < expectedResult.size(); i++){
            if (!expectedResult.get(i).equals(actualResult.get(i))){
                fail();
            }
        }
    }
}
