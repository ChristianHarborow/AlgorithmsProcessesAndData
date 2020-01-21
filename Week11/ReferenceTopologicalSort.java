package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * An implementation of a reference counting topological sort.
 *
 * @author Christian Harborow
 * @version January 2020
 */
public class ReferenceTopologicalSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T>{

    /**
     * Performs a topological sort on this graph, if it is acyclic.
     *
     * @return a topological sort of this graph
     * @throws GraphError if the graph is not acyclic
     */
    @Override
    public List<T> getSort() throws GraphError {
        ArrayList<T> topologicalSort = new ArrayList<>();
        HashMap<T, Integer> references = new HashMap<>();

        for (T node:getNodes()) {
            references.put(node, 0);
        }

        for (T node:getNodes()) {
            for (T neighbour:getNeighbours(node)) {
                references.replace(neighbour, references.get(neighbour) + 1);
            }
        }

        while (references.keySet().size() != 0 ){
            boolean acyclic = false;

            for (T node:(T[])references.keySet().toArray()) {
                if (references.get(node) == 0){
                    topologicalSort.add(node);

                    for (T neighbour:getNeighbours(node)) {
                        references.replace(neighbour, references.get(neighbour) - 1);
                    }

                    references.remove(node);
                    acyclic = true;
                }
            }

            if (!acyclic) throw new GraphError("Graph is not acyclic, topological sort cannot be found");
        }

        return topologicalSort;
    }
}
