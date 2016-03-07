package alg;

import datastructures.Graph;
import datastructures.Queue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BreadthFirstIterator implements Iterator<Integer> {
    private Set<Integer> visited = new HashSet<>();
    private Queue<Integer> queue = new Queue<>();
    private Graph graph;

    public BreadthFirstIterator(Graph g, Integer startingVertex) {
        this.graph = g;
        this.queue.add(startingVertex);
        this.visited.add(startingVertex);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public Integer next() {
        Integer next = queue.remove();
        for (Integer neighbor : this.graph.getNeighbors(next)) {
            if (!this.visited.contains(neighbor)) {
                this.queue.add(neighbor);
                this.visited.add(neighbor);
            }
        }
        return next;
    }
}