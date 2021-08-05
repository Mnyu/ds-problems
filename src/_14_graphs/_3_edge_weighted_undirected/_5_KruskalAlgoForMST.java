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
            minPQ.add(e);
        }
        UnionFind uf = new UnionFind(graph.getVertices());
        while (!minPQ.isEmpty() && mst.size() < graph.getVertices()) {
            _1_Edge minEdge = minPQ.remove();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (!uf.isConnected(v, w)) {
                uf.union(v, w);
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
}
