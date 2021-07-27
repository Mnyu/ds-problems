package _14_graphs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] visited;
    private int[] parent;
    private final int source;

    public DepthFirstPaths(Graph graph, int source) {
        this.source = source;
        this.parent = new int[graph.vertices()];
        this.visited = new boolean[graph.vertices()];
        validateVertex(source);
        System.out.println();
        System.out.println("DFS : ");
        Arrays.fill(parent, -1);
        parent[source] = source;
        dfs(graph, source);
        System.out.println();
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
        int x = v;
        Deque<Integer> stack = new LinkedList<>();
        while (x != source) {
            stack.addFirst(x);
            x = parent[x];
        }
        stack.addFirst(source);
        return stack;
    }

    private void dfs(Graph graph, int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                parent[w] = v;
                dfs(graph, w);
            }
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v > visited.length) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
    }
}
