import binaryTree.BinaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class BinaryTreeTesting {

    private BinaryTree<Integer> populateTree(ArrayList<Integer> list){
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (Integer value:list) {
            tree.insert(value);
        }

        return tree;
    }

    private void traversalTest(ArrayList<Integer> list){
        BinaryTree<Integer> tree = populateTree(list);
        List<Integer> traversalList = tree.traverse();
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals(traversalList.get(i))){
                fail();
            }
        }
    }

    private void containsTest(ArrayList<Integer> list){
        BinaryTree<Integer> tree = populateTree(list);

        for (Integer value:list) {
            if (!tree.contains(value)){
                fail();
            }
        }
    }

    private void leftTreeTest(ArrayList<Integer> list){
        BinaryTree<Integer> tree = populateTree(list);
        int root = list.get(0);
        Collections.sort(list);
        list.subList(list.indexOf(root), list.size()).clear();
        List<Integer> leftTraversal = tree.getLeft().traverse();

        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals(leftTraversal.get(i))){
                fail();
            }
        }
    }

    private void rightTreeTest(ArrayList<Integer> list){
        BinaryTree<Integer> tree = populateTree(list);
        int root = list.get(0);
        Collections.sort(list);
        list.subList(0, list.indexOf(root) + 1).clear();
        List<Integer> rightTraversal = tree.getRight().traverse();

        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals(rightTraversal.get(i))){
                fail();
            }
        }
    }

    @Test
    void getValueTest(){
        int value = 7;
        BinaryTree<Integer> tree = new BinaryTree<>(value);
        if (tree.getValue() != value){
            fail();
        }
    }

    @Test
    void getValueExceptionTest(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertThrows(NullPointerException.class, ()->tree.getValue());
    }


    @Test
    void traversalTest1(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(7, 3, 9, 4, 10, 2, 5, 3, 6));
        traversalTest(list);
    }

    @Test
    void traversalTest2(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(61, 1, 89, 17, 63, 61, 54, 66, 18, 35));
        traversalTest(list);
    }

    @Test
    void traversalTest3(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(143, 29, 1, 398, 357, 842, 486, 30, 644, 806, 580));
        traversalTest(list);
    }

    @Test
    void containsTest1(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(7, 3, 9, 4, 10, 2, 5, 3, 6));
        containsTest(list);
    }

    @Test
    void containsTest2(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(61, 1, 89, 17, 63, 61, 54, 66, 18, 35));
        containsTest(list);
    }

    @Test
    void containsTest3(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(143, 29, 1, 398, 357, 842, 486, 30, 644, 806, 580));
        containsTest(list);
    }

    @Test
    void leftTreeTest1(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(7, 3, 9, 4, 10, 2, 5, 3, 6));
        leftTreeTest(list);
    }

    @Test
    void leftTreeTest2(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(61, 1, 89, 17, 63, 61, 54, 66, 18, 35));
        leftTreeTest(list);
    }

    @Test
    void leftTreeTest3(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(143, 29, 1, 398, 357, 842, 486, 30, 644, 806, 580));
        leftTreeTest(list);
    }

    @Test
    void rightTreeTest1(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(7, 3, 9, 4, 10, 2, 5, 3, 6));
        rightTreeTest(list);
    }

    @Test
    void rightTreeTest2(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(61, 1, 89, 17, 63, 61, 54, 66, 18, 35));
        rightTreeTest(list);
    }

    @Test
    void rightTreeTest3(){
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(143, 29, 1, 398, 357, 842, 486, 30, 644, 806, 580));
        rightTreeTest(list);
    }
}