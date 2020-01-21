package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of depth first traversal.
 *
 * @author Christian Harborow
 * @version January 2020
 */

 public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {
     private ArrayList<T> traversalList;

    /**
     * Perform a traversal of the graph, and return the nodes in the order in which they are visited.
     *
     * @return a traversal of the graph in which each node is visited exactly once.
     * @throws GraphError if non-existent nodes or edges are accessed during the attempt to build the traversal.
     */
     public List<T> traverse() throws GraphError {
         traversalList = new ArrayList<>();
         T[] nodes = (T[]) getNodes().toArray();

         for (T node:nodes) {
             if (traversalList.contains(node)) {
                 continue;
             }
             nextNode(node);
         }
         return traversalList;
     }

    /**
     * A recursive function that adds a node to the traversal list then attempts to find the next unvisited node
     * by first searching the given node's neighbours and then unravelling in order to backtrack
     *
     * @param node the next node to be added to the traversal list
     * @throws GraphError if non-existent nodes or edges are accessed during the attempt to build the traversal.
     */
     private void nextNode(T node) throws GraphError{
         traversalList.add(node);

         T[] neighbours = (T[]) getNeighbours(node).toArray();

         for (T neighbour:neighbours) {
             if (!traversalList.contains(neighbour)) {
                 nextNode(neighbour);
             }
         }
     }
 }