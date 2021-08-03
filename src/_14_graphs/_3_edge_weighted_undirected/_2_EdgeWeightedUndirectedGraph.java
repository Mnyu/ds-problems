package _14_graphs._3_edge_weighted_undirected;

import java.util.LinkedList;
import java.util.List;

public class _2_EdgeWeightedUndirectedGraph {

    private int vertices;
    private int edges;
    private List<_1_Edge>[] adj;

    public _2_EdgeWeightedUndirectedGraph(int vertices) {
        if (vertices < 0) {
            throw new IllegalArgumentException("Invalid no of vertices");
        }
        this.vertices = vertices;
        this.edges = 0;
        this.adj = (List<_1_Edge>[]) new List[vertices];
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

    public void addEdge(_1_Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(edge);
        adj[w].add(edge);
        edges++;
    }

    public Iterable<_1_Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public Iterable<_1_Edge> getAllEdges() {
        List<_1_Edge> list = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            int selfLoops = 0;
            for (_1_Edge edge : adj[i]) {
                if (edge.other(i) > i) {
                    list.add(edge);
                } else if (edge.other(i) == i) {
                    if (selfLoops % 2 == 0)
                        list.add(edge);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }
}
