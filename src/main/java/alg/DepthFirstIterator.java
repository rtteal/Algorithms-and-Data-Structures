package alg;

import datastructures.Graph;
import datastructures.Stack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DepthFirstIterator implements Iterator<Integer> {
    private Set<Integer> visited = new HashSet<>();
    private Stack<Integer> stack = new Stack<>();
    private Graph graph;

    public DepthFirstIterator(Graph g, Integer startingVertex) {
        this.graph = g;
        this.stack.push(startingVertex);
        this.visited.add(startingVertex);
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    @Override
    public Integer next() {
        Integer next = stack.pop();
        for (Integer neighbor : this.graph.getNeighbors(next)) {
            if (!this.visited.contains(neighbor)) {
                this.stack.push(neighbor);
                this.visited.add(neighbor);
            }
        }
        return next;
    }
}