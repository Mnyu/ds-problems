package _14_graphs._1_undirected;

/**
 * Cycle detection in Undirected Graphs
 * Run DFS and if for any node, there is another node that is already visited and is not the parent of the current node,
 * that means there is a cycle in the graph
 */
public class _4_CycleDetector {

    public boolean isCyclePresent(_1_UndirectedGraph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                boolean isCyclePresent = dfs(graph, i, i, visited);
                if (isCyclePresent)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(_1_UndirectedGraph graph, int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                boolean isCyclePresent = dfs(graph, w, v, visited);
                if (isCyclePresent)
                    return true;
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }
}
