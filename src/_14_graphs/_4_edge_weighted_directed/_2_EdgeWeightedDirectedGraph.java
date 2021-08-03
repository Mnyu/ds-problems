package _14_graphs._4_edge_weighted_directed;

import java.util.LinkedList;
import java.util.List;

public class _2_EdgeWeightedDirectedGraph {

    private final int vertices;
    private int edges;
    private List<_1_DirectedEdge>[] adj;

    public _2_EdgeWeightedDirectedGraph(int vertices) {
        if (vertices < 0) {
            throw new IllegalArgumentException("Illegal number of vertices.");
        }
        this.vertices = vertices;
        this.edges = 0;
        this.adj = (List<_1_DirectedEdge>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(_1_DirectedEdge edge) {
        int src = edge.from();
        int dest = edge.to();
        validateVertex(src);
        validateVertex(dest);
        adj[src].add(edge);
        edges++;
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public Iterable<_1_DirectedEdge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }
}
