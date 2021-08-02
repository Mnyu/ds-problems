package _14_graphs._2_directed;

/**
 * For Directed Graphs Cycle Detector
 * Run DFS and keep track of vertices on stack for the dfs path
 * If for any node, there is another node that is on stack, that means there is a cycle.
 */
public class _4_CycleDetectorDirected {

    public boolean isCyclePresent(_1_DirectedGraph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        boolean[] onStack = new boolean[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++) {
            boolean isCyclePresent = dfs(graph, i, visited, onStack);
            if(isCyclePresent)
                return true;
        }
        return false;
    }

    private boolean dfs(_1_DirectedGraph graph, int v, boolean[] visited, boolean[] onStack) {
        visited[v] = true;
        onStack[v] = true;
        for (int w : graph.adj(v)) {
            if (onStack[w])
                return true;
            if (!visited[w]) {
                boolean isCyclePresent = dfs(graph, w, visited, onStack);
                if(isCyclePresent)
                    return true;
            }
        }
        onStack[v] = false;
        return false;
    }
}
