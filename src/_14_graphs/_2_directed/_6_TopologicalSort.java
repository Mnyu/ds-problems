package _14_graphs._2_directed;

import java.util.Deque;
import java.util.LinkedList;

public class _6_TopologicalSort {

    private boolean[] visited;
    private boolean[] onStack;

    public Iterable<Integer> get(_1_DirectedGraph graph) {
        this.visited = new boolean[graph.getVertices()];
        this.onStack = new boolean[graph.getVertices()];
        Deque<Integer> topoOrderStack = new LinkedList<>();
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(graph, i, topoOrderStack);
            }
        }
        return topoOrderStack;
    }

    private void dfs(_1_DirectedGraph graph, int v, Deque<Integer> topoOrderStack) {
        visited[v] = true;
        onStack[v] = true;
        for (int w : graph.adj(v)) {
            if (onStack[w]) {
                throw new RuntimeException("Graph contains cycle, can't find topological order");
            } else if (!visited[w]) {
                dfs(graph, w, topoOrderStack);
            }
        }
        onStack[v] = false;
        topoOrderStack.addFirst(v);
    }
    // Time Complexity : O(V+E)
    // Space Complexity : O(V)
}
