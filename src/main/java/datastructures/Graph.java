package datastructures;

public class Graph {

    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(Integer v, Integer w) {
        E++;
        adj[v].add(v);
        adj[v].add(w);
    }

    public Iterable<Integer> getNeighbors(int vertex) {
        return adj[vertex];
    }

    public int numVertices() {
        return V;
    }

    public int numEdges() {
        return E;
    }
}
