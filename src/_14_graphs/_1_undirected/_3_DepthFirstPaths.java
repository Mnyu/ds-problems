package _14_graphs._1_undirected;

import java.util.Deque;
import java.util.LinkedList;

public class _3_DepthFirstPaths {
    private final int source;
    private final boolean[] visited;
    private final int[] parent;

    public _3_DepthFirstPaths(_1_UndirectedGraph graph, int source) {
        this.source = source;
        this.parent = new int[graph.getVertices()];
        this.visited = new boolean[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++) {
            parent[i] = -1;
        }
        validateVertex(source);
        parent[source] = source;
        dfs(graph, source);
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = v; i != source; i = parent[i]) {
            stack.addFirst(i);
        }
        stack.addFirst(source);
        return stack;
    }

    private void dfs(_1_UndirectedGraph graph, int v) {
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                parent[w] = v;
                dfs(graph, w);
            }
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= visited.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }

}
