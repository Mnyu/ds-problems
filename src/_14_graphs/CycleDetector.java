package _14_graphs;

public class CycleDetector {

    public boolean containsCycleUndirected(Graph graph) {
        boolean[] visited = new boolean[graph.vertices()];
        for (int i = 0; i < graph.vertices(); i++) {
            if (!visited[i] && containsCycleUndirectedDFS(graph, i, -1, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsCycleUndirectedDFS(Graph graph, int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                boolean containsCycle = containsCycleUndirectedDFS(graph, w, v, visited);
                if (containsCycle) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean containsCycle(Graph graph) {
        boolean[] visited = new boolean[graph.vertices()];
        boolean[] onStack = new boolean[graph.vertices()];
        for (int i = 0; i < graph.vertices(); i++) {
            if (!visited[i] && containsCycleDFS(graph, i, visited, onStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsCycleDFS(Graph graph, int v, boolean[] visited, boolean[] onStack) {
        visited[v] = true;
        onStack[v] = true;
        for (int w : graph.adj(v)) {
            if (onStack[w]) {
                return true;
            }
            if (!visited[w] && containsCycleDFS(graph, w, visited, onStack)) {
                return true;
            }
        }
        onStack[v] = false;
        return false;
    }
}
