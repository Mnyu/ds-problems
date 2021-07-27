package _14_graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int vertices;
    private int edges;
    private boolean directed;
    private List<Integer>[] adj;

    public Graph(int v, boolean directed) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices > 0 required");
        }
        this.directed = directed;
        this.vertices = v;
        this.edges = 0;
        this.adj = (List<Integer>[]) new List[v];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int vertices() {
        return vertices;
    }

    public int edges() {
        return edges;
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        edges++;
        adj[v].add(w);
        if (!directed) {
            adj[w].add(v);
        }
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vertices).append(" vertices ").append(edges).append(" edges").append(System.lineSeparator());
        for (int i = 0; i < vertices; i++) {
            sb.append(i).append(" -> ");
            for (int v : adj[i]) {
                sb.append(v).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
    }
}
