package _14_graphs._4_edge_weighted_directed;

import java.util.Deque;
import java.util.LinkedList;

public class _7_LongestPathInDAGRecursive {

    private _4_TopologicalSortShortestPaths tpSPs;

    public _7_LongestPathInDAGRecursive(_2_EdgeWeightedDirectedGraph graph, int source) {
        _2_EdgeWeightedDirectedGraph negatedGraph = getNegatedGraph(graph);
        tpSPs = new _4_TopologicalSortShortestPaths(negatedGraph, source);
    }

    public double longDistTo(int v) {
        return -1 * tpSPs.distTo(v);
    }

    public boolean hasPathTo(int v) {
        return tpSPs.hasPathTo(v);
    }

    public Iterable<_1_DirectedEdge> pathTo(int v) {
        Deque<_1_DirectedEdge> queue = new LinkedList<>();
        for (_1_DirectedEdge e : tpSPs.pathTo(v)) {
            queue.addLast(new _1_DirectedEdge(e.from(), e.to(), -1 * e.getWeight()));
        }
        return queue;
    }

    private _2_EdgeWeightedDirectedGraph getNegatedGraph(_2_EdgeWeightedDirectedGraph graph) {
        _2_EdgeWeightedDirectedGraph negatedGraph = new _2_EdgeWeightedDirectedGraph(graph.getVertices());
        for (int i = 0; i < graph.getVertices(); i++) {
            for (_1_DirectedEdge e : graph.adj(i)) {
                negatedGraph.addEdge(new _1_DirectedEdge(e.from(), e.to(), -1 * e.getWeight()));
            }
        }
        return negatedGraph;
    }
}
