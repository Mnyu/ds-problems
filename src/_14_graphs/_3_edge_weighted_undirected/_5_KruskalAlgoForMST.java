package _14_graphs._3_edge_weighted_undirected;

import _16_union_find.UnionFind;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Kruskal's Algo for MST :
 * 1. Consider edges in ascending order of weight.
 * 2. Add edge to MST, if its addition to MST does not lead to a cycle.
 */
public class _5_KruskalAlgoForMST {
    private double weight;
    private Deque<_1_Edge> mst;

    public _5_KruskalAlgoForMST(_2_EdgeWeightedUndirectedGraph graph) {
        mst = new LinkedList<>();
        PriorityQueue<_1_Edge> minPQ = new PriorityQueue<>();
        for (_1_Edge e : graph.getAllEdges()) {
            minPQ.add(e); // O(logE)
        }
        UnionFind uf = new UnionFind(graph.getVertices());
        while (!minPQ.isEmpty() && mst.size() < graph.getVertices()) {
            _1_Edge minEdge = minPQ.remove(); // O(logE)
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (!uf.isConnected(v, w)) {    // O(log*V)
                uf.union(v, w); // O(log*V)
                mst.addLast(minEdge);
                weight = weight + minEdge.getWeight();
            }
        }
    }

    public double getWeight() {
        return weight;
    }

    public Iterable<_1_Edge> getMST() {
        return mst;
    }

    // Time Complexity : O(ElogE) [adding all edges to pq] +
    //                   O(VlogE) [remove min edge from pd] +
    //                   O(Vlog*V) [uf.isConnected check] +
    //                   O(Vlog*V) [uf.union]
    //                  = O(ElogE)
    // Space Complexity : O(E)

}
