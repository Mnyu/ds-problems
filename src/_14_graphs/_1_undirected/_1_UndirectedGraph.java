package _14_graphs._1_undirected;

import java.util.LinkedList;
import java.util.List;

public class _1_UndirectedGraph {
    private final int vertices;
    private int edges;
    private List<Integer>[] adj;

    public _1_UndirectedGraph(int vertices) {
        if (vertices < 0)
            throw new IllegalArgumentException("Vertex count > 0 required.");
        this.vertices = vertices;
        this.edges = 0;
        this.adj = (List<Integer>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("Vertex range is 0 to " + (vertices - 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            sb.append(i).append(" --> ");
            for (int w : adj[i]) {
                sb.append(w).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
