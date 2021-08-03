package _14_graphs._4_edge_weighted_directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * The Generic Shortest Path algo from single source S is :
 * 1. Initialize distTo[S] = 0 and distTo[rest-vertices] = infinity
 * 2. Relax any edge e(v --> w) to satisfy the conditions :
 * distTo[w] <= distTo[v] + e.getWeight()
 * <p>
 * Efficient implementations based on - HOW TO CHOOSE WHICH EDGE TO RELAX
 * <p>
 * SHORTEST PATH USING TOPOLOGICAL SORT  :
 * Requirement : GRAPH SHOULD BE DAG - No directed cycles in graph
 * How to choose edge :
 * 1. CONSIDER THE VERTICES IN TOPOLOGICAL ORDER.
 * 2. RELAX ALL EDGES POINTING OUT FROM THAT VERTEX.
 */
public class _4_TopologicalSortShortestPaths {

    private double[] distTo;
    private _1_DirectedEdge[] edgeTo;

    public _4_TopologicalSortShortestPaths(_2_EdgeWeightedDirectedGraph graph, int source) {

        List<Integer> sortedVertices = getVerticesInSortedOrder(graph); // O(V + E) [dfs used]

        distTo = new double[graph.getVertices()];
        edgeTo = new _1_DirectedEdge[graph.getVertices()];
        validateVertex(source);

        Arrays.fill(distTo, Double.POSITIVE_INFINITY); // O(V)
        distTo[source] = 0;
        topoSortShortestPaths(graph, sortedVertices); // O(E)
    }

    private void topoSortShortestPaths(_2_EdgeWeightedDirectedGraph graph, List<Integer> sortedVertices) {
        for (int vertex : sortedVertices) {
            for (_1_DirectedEdge edge : graph.adj(vertex)) {
                relaxEdge(edge); // O(1)
            }
        }
    }

    private void relaxEdge(_1_DirectedEdge edge) {
        int src = edge.from();
        int dest = edge.to();
        if (distTo[dest] > distTo[src] + edge.getWeight()) {
            distTo[dest] = distTo[src] + edge.getWeight();
            edgeTo[dest] = edge;
        }
    }


    private List<Integer> getVerticesInSortedOrder(_2_EdgeWeightedDirectedGraph graph) {
        Deque<Integer> topoOrderStack = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVertices()];
        boolean[] onStack = new boolean[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, onStack, topoOrderStack);
            }
        }
        return new ArrayList<>(topoOrderStack);
    }

    private void dfs(_2_EdgeWeightedDirectedGraph graph, int v, boolean[] visited,
                     boolean[] onStack, Deque<Integer> topoOrderStack) {
        visited[v] = true;
        onStack[v] = true;
        for (_1_DirectedEdge edge : graph.adj(v)) {
            int w = edge.to();
            if (onStack[w]) {
                throw new RuntimeException("Graph contains cycle, topological sort cannot be applied");
            } else if (!visited[w]) {
                dfs(graph, w, visited, onStack, topoOrderStack);
            }
        }
        onStack[v] = false;
        topoOrderStack.addFirst(v);
    }

    public boolean hasPathTo(int v) {
        return distTo(v) != Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
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
        if (v < 0 || v >= distTo.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }
    // Time Complexity : O(V+E)
    // Space Complexity : O(V)
}
