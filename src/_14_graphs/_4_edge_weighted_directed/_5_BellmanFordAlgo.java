package _14_graphs._4_edge_weighted_directed;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * The Generic Shortest Path algo from single source S is :
 * 1. Initialize distTo[S] = 0 and distTo[rest-vertices] = infinity
 * 2. Relax any edge e(v --> w) to satisfy the conditions :
 * distTo[w] <= distTo[v] + e.getWeight()
 * <p>
 * Efficient implementations based on - HOW TO CHOOSE WHICH EDGE TO RELAX
 * <p>
 * BELLMAN FORD ALGO :
 * Requirement : NO NEGATIVE CYCLE - A negative cycle is a directed cycle whose sum of edge weights < 0
 * How to choose edge :
 * 1. INITIALIZE distTo[S] = 0 AND distTo[rest-vertices] = infinity
 * 2. REPEAT V TIMES : RELAX EACH EDGE
 */
public class _5_BellmanFordAlgo {
    private double[] distTo;
    private _1_DirectedEdge[] edgeTo;

    public _5_BellmanFordAlgo(_2_EdgeWeightedDirectedGraph graph, int source) {
        distTo = new double[graph.getVertices()];
        edgeTo = new _1_DirectedEdge[graph.getVertices()];
        validateSource(source);

        Arrays.fill(distTo, Double.POSITIVE_INFINITY); // O(V)
        distTo[source] = 0;
        for (int i = 0; i < graph.getVertices(); i++) {
            for (int v = 0; v < graph.getVertices(); v++) {
                for (_1_DirectedEdge edge : graph.adj(v)) {
                    relax(edge);
                }
            }
        }
        for (int i = 0; i < graph.getVertices(); i++) {
            for (int v = 0; v < graph.getVertices(); v++) {
                for (_1_DirectedEdge edge : graph.adj(v)) {
                    int src = edge.from();
                    int dest = edge.to();
                    if (distTo[dest] > distTo[src] + edge.getWeight()) {
                        throw new RuntimeException("Negative cycle exists in the graph");
                    }
                }
            }
        }
    }

    private void relax(_1_DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        if (distTo[w] > distTo[v] + edge.getWeight()) {
            distTo[w] = distTo[v] + edge.getWeight();
            edgeTo[w] = edge;
        }
    }

    public double distTo(int v) {
        validateSource(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo(v) != Double.POSITIVE_INFINITY;
    }

    public Iterable<_1_DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Deque<_1_DirectedEdge> stack = new LinkedList<>();
        for (_1_DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            stack.addFirst(e);
        }
        return stack;
    }

    private void validateSource(int v) {
        if (v < 0 || v >= distTo.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }
}
// Time Complexity : O(VE)
// Space Complexity : O(V)
