package _14_graphs._3_edge_weighted_undirected;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

public class _4_EagerPrimsAlgoForMST {
    private double weight;
    private Deque<_1_Edge> mst;
    private boolean[] visited;
    private PrimNode[] vertexToPrimNode;
    private TreeSet<PrimNode> treeSet;
    private int primNodeCounter;

    public _4_EagerPrimsAlgoForMST(_2_EdgeWeightedUndirectedGraph graph) {
        mst = new LinkedList<>();
        visited = new boolean[graph.getVertices()];
        vertexToPrimNode = new PrimNode[graph.getVertices()];
        treeSet = new TreeSet<>();
        primNodeCounter = 0;
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                prim(graph, i);
            }
        }
    }

    private void prim(_2_EdgeWeightedUndirectedGraph graph, int v) {
        visit(graph, v);
        while (!treeSet.isEmpty()) {
            PrimNode node = treeSet.pollFirst(); // O(logV)
            int w = node.vertex;
            mst.addLast(node.edge);
            weight = weight + node.edge.getWeight();
            visit(graph, w);
        }
    }
    // Frequency to call treeSet.pollFirst() = V  => total complexity = O(VlogV)
    // Frequency to call visit(graph, w) = E => total complexity = O(ElogV)

    private void visit(_2_EdgeWeightedUndirectedGraph graph, int v) {
        visited[v] = true;
        for (_1_Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            if (!visited[w]) {
                if (vertexToPrimNode[w] != null && vertexToPrimNode[w].edge.getWeight() <= edge.getWeight()) {
                    continue;
                }
                if (vertexToPrimNode[w] != null) {
                    treeSet.remove(vertexToPrimNode[w]); // O(logV)
                }
                vertexToPrimNode[w] = new PrimNode(primNodeCounter++, edge, w);
                treeSet.add(vertexToPrimNode[w]);// O(logV)
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

// Time Complexity : O(ElogV + VlogV) ~ O(ElogV)
// Space Complexity : O(V)

class PrimNode implements Comparable<PrimNode> {
    public int id;
    public int vertex;
    public _1_Edge edge;

    public PrimNode(int id, _1_Edge edge, int vertex) {
        this.id = id;
        this.edge = edge;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(PrimNode o) {
        if (this.edge.getWeight() == o.edge.getWeight())
            return Integer.compare(this.id, o.id);
        return Double.compare(this.edge.getWeight(), o.edge.getWeight());
    }
}
