package _14_graphs._1_undirected;

import java.util.Arrays;

/**
 * Vertices v and w are connected if there is a path b/w them.
 * <p>
 * Goal : Answer query - IS V CONNECTED TO W ? ---- in O(1) [constant] time.
 * To answer this query in constant time we need some pre-processing on the graph.
 */
public class _5_ConnectedComponents {

    private boolean[] visited;
    private int[] componentIds;
    private int[] componentSizes;
    private int noOfConnectedComponents;

    public _5_ConnectedComponents(_1_UndirectedGraph graph) {
        this.visited = new boolean[graph.getVertices()];
        this.componentIds = new int[graph.getVertices()];
        this.componentSizes = new int[graph.getVertices()];
        Arrays.fill(componentIds, -1);
        noOfConnectedComponents = 0;
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(graph, i);
                noOfConnectedComponents++;
            }
        }
    }

    public boolean isConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return componentIds[v] == componentIds[w];
    }

    public int getComponentId(int v) {
        validateVertex(v);
        return componentIds[v];
    }

    public int getComponentSize(int componentId) {
        validateVertex(componentId);
        return componentSizes[componentId];
    }

    public int getNoOfConnectedComponents(){
        return noOfConnectedComponents;
    }

    private void dfs(_1_UndirectedGraph graph, int v) {
        visited[v] = true;
        componentIds[v] = noOfConnectedComponents;
        componentSizes[noOfConnectedComponents]++;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(graph, w);
            }
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= visited.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }

    // Time Complexity :
    //      Pre-process graph : O(V+E) [DFS]
    //      Query - is v connected to w? : O(1) - after pre-processing

    // Space Complexity : O(V)
}
