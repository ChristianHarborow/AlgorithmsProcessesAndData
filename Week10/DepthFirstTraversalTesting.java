import graph.DepthFirstTraversal;
import graph.GraphError;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class DepthFirstTraversalTesting {

    @Test
    void traversalTest1() throws GraphError {

        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 3));
        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

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

        List<Integer> actualResult = graph.traverse();

        for (int i = 0; i < expectedResult.size(); i++){
            if (!expectedResult.get(i).equals(actualResult.get(i))){
                fail();
            }
        }
    }

    @Test
    void traversalTest2() throws GraphError {
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 3, 5, 7, 6, 8));
        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

        for (int i = 0; i < 9; i++){
            graph.add(i);
        }

        graph.add(0, 1);
        graph.add(0, 4);
        graph.add(1, 2);
        graph.add(4, 3);
        graph.add(4, 5);
        graph.add(4, 7);
        graph.add(6, 8);

        List<Integer> actualResult = graph.traverse();

        for (int i = 0; i < expectedResult.size(); i++){
            if (!expectedResult.get(i).equals(actualResult.get(i))){
                fail();
            }
        }
    }

    @Test
    void traversalTest3() throws GraphError {
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1, 4, 2, 6, 10, 9, 11, 8, 3, 5, 7));
        DepthFirstTraversal<Integer> graph = new DepthFirstTraversal<>();

        for (int i = 0; i < 12; i++){
            graph.add(i);
        }

        graph.add(0, 1);
        graph.add(0, 3);
        graph.add(1, 4);
        graph.add(3, 5);
        graph.add(4, 2);
        graph.add(4, 6);
        graph.add(4, 8);
        graph.add(5, 7);
        graph.add(6, 10);
        graph.add(7, 10);
        graph.add(7, 11);
        graph.add(8, 9);
        graph.add(10, 9);
        graph.add(10, 11);

        List<Integer> actualResult = graph.traverse();

        for (int i = 0; i < expectedResult.size(); i++){
            if (!expectedResult.get(i).equals(actualResult.get(i))){
                fail();
            }
        }
    }

}
