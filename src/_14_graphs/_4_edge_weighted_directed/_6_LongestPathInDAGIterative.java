package _14_graphs._4_edge_weighted_directed;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _6_LongestPathInDAGIterative {
    private int[] inDegree;
    private double[] longDistTo;
    private _1_DirectedEdge[] edgeTo;
    private boolean[] visited;


    public _6_LongestPathInDAGIterative(_2_EdgeWeightedDirectedGraph graph) {

        // Validate if graph contains cycle - O(V+E)

        edgeTo = new _1_DirectedEdge[graph.getVertices()];
        longDistTo = new double[graph.getVertices()];
        inDegree = new int[graph.getVertices()];
        Arrays.fill(longDistTo, Double.NEGATIVE_INFINITY); // O(V)
        longestPathIterative(graph); // O(V+E)
    }

    private void longestPathIterative(_2_EdgeWeightedDirectedGraph graph) {
        populateInDegrees(graph); // O(E)

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.getVertices(); i++) {         // O(V)
            if (inDegree[i] == 0) {
                queue.addLast(i);
                longDistTo[i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (_1_DirectedEdge edge : graph.adj(v)) {
                int w = edge.to();
                inDegree[w]--;
                if (longDistTo[w] < longDistTo[v] + edge.getWeight()) {
                    longDistTo[w] = longDistTo[v] + edge.getWeight();
                    edgeTo[w] = edge;
                }
                if (inDegree[w] == 0) {
                    queue.addLast(w);
                }
            }
        }
    }

    private void populateInDegrees(_2_EdgeWeightedDirectedGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (_1_DirectedEdge edge : graph.adj(i)) {
                inDegree[edge.to()]++;
            }
        }
    }

    public double longDistTo(int v) {
        validateVertex(v);
        return longDistTo[v];
    }

    public boolean hasPathTo(int v) {
        return longDistTo(v) != Double.NEGATIVE_INFINITY;
    }

    public Iterable<_1_DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Deque<_1_DirectedEdge> stack = new LinkedList<>();
        for (_1_DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            stack.addFirst(e);
        }
        return stack;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= longDistTo.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }


}
