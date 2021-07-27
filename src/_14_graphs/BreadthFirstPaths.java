package _14_graphs;

import java.util.Deque;
import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean[] visited;
    private int[] parent;
    private int[] distTo;

    public BreadthFirstPaths(Graph graph, int source) {
        visited = new boolean[graph.vertices()];
        parent = new int[graph.vertices()];
        distTo = new int[graph.vertices()];
        validateVertex(source);
        bfs(graph, source);
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return visited[v];
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<Integer> stack = new LinkedList<>();
        int x = v;
        while (distTo[x] != 0) {
            stack.addFirst(x);
            x = parent[x];
        }
        stack.addFirst(x);
        return stack;
    }

    private void bfs(Graph graph, int source) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.vertices(); i++) {
            distTo[i] = -1;
            parent[i] = -1;
        }
        distTo[source] = 0;
        visited[source] = true;
        parent[source] = source;

        queue.addLast(source);
        System.out.println("BFS : ");
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            System.out.print(v + " ");
            for (int w : graph.adj(v)) {
                if (!visited[w]) {
                    parent[w] = v;
                    distTo[w] = distTo[v] + 1;
                    visited[w] = true;
                    queue.addLast(w);
                }
            }
        }
        System.out.println();
    }

    private void validateVertex(int v) {
        if (v < 0 || v > visited.length) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
    }
}
