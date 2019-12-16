package linkedList.list;

import linkedList.node.SingleLinkNode;

/**
 * Implementation of a list using single link nodes
 *
 * @param <T> the type of object to be stored in the list.
 * @author Christian Harborow
 * @version December 2019
 */
public class SinglyLinkedList<T> extends BasicList<SingleLinkNode<T>, T> implements List<T> {
    /**
     * Add a new value to the list at position index
     *
     * @param index the index at which the new entry should be added.
     * @param value the value to be added.
     * @throws ListAccessError if index is an invalid index.
     */
    @Override
    public void add(int index, T value) throws ListAccessError {
        SingleLinkNode<T> newNode = new SingleLinkNode<>(value);
        if (index == 0) {
            newNode.setNext(this.root);
            this.setRoot(newNode);
            return;
        }

        if (this.isEmpty()) throw new ListAccessError("No node at index 0, cannot add at index " + index);

        SingleLinkNode<T> previousNode = getNode(index - 1);

        newNode.setNext(previousNode.getNext());
        previousNode.setNext(newNode);
    }

    /**
     * Remove a value from the list at the index specified.
     *
     * @param index the index of the entry to be removed.
     * @return the value removed.
     * @throws ListAccessError if index is an invalid index.
     */
    @Override
    public T remove(int index) throws ListAccessError {
        if (this.isEmpty()) throw new ListAccessError("Tried to remove an element from an empty list");

        if (index == 0) {
            T value = this.getRoot().getValue();
            this.setRoot(this.getRoot().getNext());
            return value;
        }

        SingleLinkNode<T> previousNode = getNode(index - 1);

        if (previousNode.getNext() == null) throw new ListAccessError("No Node at index " + index);

        T value = previousNode.getNext().getValue();
        previousNode.setNext(previousNode.getNext().getNext());

        return value;
    }

    /**
     * Get a value from the list at the index specified (do not remove it)
     *
     * @param index the index of the entry to be accessed.
     * @return the value indexed.
     * @throws ListAccessError if index is an invalid index.
     */
    @Override
    public T get(int index) throws ListAccessError {
        if (this.isEmpty()) throw new ListAccessError("Tried to get node from an empty list");
        SingleLinkNode<T> node = getNode(index);
        return node.getValue();
    }

    /**
     * Returns the node at the specified index
     *
     * @param index the index of the node to be returned.
     * @throws ListAccessError if index is invalid.
     */
    private SingleLinkNode<T> getNode(int index) throws ListAccessError {
        SingleLinkNode<T> node = this.getRoot();

        for (int i = 0; i < index; i++) {
            if (node.getNext() != null) {
                node = node.getNext();
            } else {
                throw new ListAccessError("No node at index " + index);
            }
        }

        return node;
    }
}