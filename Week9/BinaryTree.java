package binaryTree;

import java.util.List;
import java.util.ArrayList;

/**
 * An implementation of a sorted binary tree.
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Christian Harborow.
 * @version January 2020.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {

    /**
     * The root node of this tree.
     */
    private TreeNode<T> root;

    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     * @param value the value to be stored in the root of the tree.
     * @param left the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value,BinaryTree<T> left,BinaryTree<T> right) {
        root = new TreeNode<>(value,left,right);
    }

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     */
    public void insert(T value) {
        if (isEmpty()) root = new TreeNode<>(value);

        else if (value.compareTo(getValue())<0) getLeft().insert(value);

        else getRight().insert(value);
    }

    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     */
    public T getValue() throws NullPointerException {
        if (root == null) throw new NullPointerException();
        return root.getValue();
    }

    /**
     * Change the value stored at the root of the tree.
     * @param value the new value to be stored at the root of the tree.
     */
    public void setValue(T value) throws NullPointerException {
        if (root == null) throw new NullPointerException();
        root.setValue(value);
    }

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     */
    public BTree<T> getLeft() throws NullPointerException {
        if (root == null) throw new NullPointerException();
        return root.getLeft();
    }

    /**
     * Change the left subtree of this tree.
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) throws NullPointerException {
        if (root == null) throw new NullPointerException();
        root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() throws NullPointerException {
        if (root == null) throw new NullPointerException();
        return root.getRight();
    }

    /**
     * Change the right subtree of this tree.
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) throws NullPointerException {
        if (root == null) throw new NullPointerException();
        root.setRight(tree);
    }

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    public boolean contains(T value) {
        if (isEmpty()) return false;

        if (root.getValue() == value) return true;

        if (value.compareTo(root.getValue()) < 0) return root.getLeft().contains(value);

        else return root.getRight().contains(value);
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    public List<T> traverse() {
        ArrayList<T> valueList = new ArrayList<>();

        if (isEmpty()) return valueList;

        valueList.addAll(root.getLeft().traverse());
        valueList.add(root.getValue());
        valueList.addAll(root.getRight().traverse());

        return valueList;
    }
}
