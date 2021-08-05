package _14_graphs._3_edge_weighted_undirected;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * The below implementation of Prim's Algo is Lazy Implementation because:
 * We allow certain edges to go into PriorityQueue that we know are obsolete (i.e. edges for which both vertices are already visited),
 * and then we pull out an edge and check whether it should be in MST or not.
 * Time Complexity of this implementation : O(ElogE) and Space Complexity : O(E) is also high
 * whereas we can achieve
 * Time Complexity of this implementation : O(ElogV) and Space Complexity : O(V) with below
 * EAGER IMPLEMENTATION :
 * The ideal way to do this is eagerly : Find minimum weight edge with exactly 1 vertex in MST.
 * This is achieved by using a custom-made IndexMinPriorityQueue and taking vertices instead of edges in IndexMinPriorityQueue.
 * This custom-made IndexMinPriorityQueue will have the capability of decreaseKey() which basically decreases the priority of the vertex.
 * [Refer Notes]
 * <p>
 * OR
 * <p>
 * There is another way by using TreeSet and some more custom classes to achieve this eager implementation
 * Check out : _4_EagerPrimsAlgoForMST class.
 */
public class _3_LazyPrimsAlgoForMST {
    private double weight;
    private Deque<_1_Edge> mst;
    private boolean[] visited;
    private PriorityQueue<_1_Edge> minPQ;

    public _3_LazyPrimsAlgoForMST(_2_EdgeWeightedUndirectedGraph graph) {
        this.weight = 0;
        this.mst = new LinkedList<>();
        this.visited = new boolean[graph.getVertices()];
        this.minPQ = new PriorityQueue<>();
        for (int i = 0; i < graph.getVertices(); i++) {
            // Run Prim for all vertices to basically get a Min. Spanning Forest.
            if (!visited[i]) {
                prim(graph, i);
            }
        }
    }

    public double getWeight() {
        return weight;
    }

    public Iterable<_1_Edge> getMST() {
        return mst;
    }

    private void prim(_2_EdgeWeightedUndirectedGraph graph, int v) {
        visit(graph, v);
        while (!minPQ.isEmpty() && mst.size() < graph.getVertices()) {
            // Here mst.size() < graph.getVertices() is an optimization to exit early when mst is done.
            // At this stage minPQ will have some edges but the vertices of those edges would already have been visited.
            _1_Edge edge = minPQ.remove(); // O(logE)
            int w = edge.either();
            int z = edge.other(w);
            if (visited[w] && visited[z]) {
                continue;
            }
            mst.addLast(edge);
            weight = weight + edge.getWeight();
            if (!visited[w]) {
                visit(graph, w);
            }
            if (!visited[z]) {
                visit(graph, z);
            }
        }
    }

    private void visit(_2_EdgeWeightedUndirectedGraph graph, int v) {
        visited[v] = true;
        for (_1_Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            if (!visited[w]) {
                minPQ.add(edge); // O(logE)
            }
        }
    }

    // Time Complexity : O(ElogE) [E times minPQ.remove() at max without optimization] +
    //                   O(ElogE) [E times minPQ.add(edge) at max]
    //                   total ~ O(ElogE)
    // Space : O(E)

}
