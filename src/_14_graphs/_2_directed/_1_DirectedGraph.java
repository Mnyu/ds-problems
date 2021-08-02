package _14_graphs._2_directed;

import java.util.LinkedList;
import java.util.List;

public class _1_DirectedGraph {
    private final int vertices;
    private int edges;
    private final List<Integer>[] adj;

    public _1_DirectedGraph(int vertices) {
        if (vertices < 1) {
            throw new IllegalArgumentException("Vertex count should be > 1");
        }
        this.vertices = vertices;
        this.edges = 0;
        this.adj = (List<Integer>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void addEdge(int v, int w) {
        // Edge is v --> w
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        edges++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
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
