package _14_graphs._1_undirected;

import java.util.Deque;
import java.util.LinkedList;

public class _2_BreadthFirstPaths {
    private final boolean[] visited;
    private final int[] parent;
    private final int[] distTo;

    public _2_BreadthFirstPaths(_1_UndirectedGraph graph, int source) {
        visited = new boolean[graph.getVertices()];
        parent = new int[graph.getVertices()];
        distTo = new int[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++) {
            distTo[i] = -1;
            parent[i] = -1;
        }
        bfs(graph, source);
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<Integer> stack = new LinkedList<>();
        int i;
        for (i = v; distTo[i] != 0; i = parent[i]) {
            stack.addFirst(i);
        }
        stack.addFirst(i);
        return stack;
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    private void bfs(_1_UndirectedGraph graph, int source) {
        validateVertex(source);
        distTo[source] = 0;
        parent[source] = source;
        visited[source] = true;
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (int w : graph.adj(v)) {
                if (!visited[w]) {
                    distTo[w] = distTo[v] + 1;
                    parent[w] = v;
                    visited[w] = true;
                    queue.addLast(w);
                }
            }
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= visited.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }
}
