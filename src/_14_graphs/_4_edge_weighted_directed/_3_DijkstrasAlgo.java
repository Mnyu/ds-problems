package _14_graphs._4_edge_weighted_directed;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * The Generic Shortest Path algo from single source S is :
 * 1. Initialize distTo[S] = 0 and distTo[rest-vertices] = infinity
 * 2. Relax any edge e(v --> w) to satisfy the conditions :
 * distTo[w] <= distTo[v] + e.getWeight()
 * <p>
 * Efficient implementations based on - HOW TO CHOOSE WHICH EDGE TO RELAX
 * <p>
 * DIJKSTRA's ALGO :
 * Requirement : NON-NEGATIVE WEIGHTS
 * How to choose edge : ALWAYS TAKE THE EDGE THAT IS CLOSEST TO THE SOURCE VERTEX S
 */
public class _3_DijkstrasAlgo {
    private double[] distTo;
    private _1_DirectedEdge[] parent;
    private TreeSet<Triplet> treeSet;
    private Triplet[] tripletsForVertex;
    private int counter;

    public _3_DijkstrasAlgo(_2_EdgeWeightedDirectedGraph graph, int source) {
        distTo = new double[graph.getVertices()];
        parent = new _1_DirectedEdge[graph.getVertices()];
        treeSet = new TreeSet<>();
        tripletsForVertex = new Triplet[graph.getVertices()];
        counter = 0;
        validateVertex(source);

        // CHECK IF GRAPH CONTAINS NEGATIVE WEIGHTS - STOP IF YES
        checkNonNegativeWeights(graph); // Complexity : O(E)

        Arrays.fill(distTo, -1); // Complexity : O(V)

        dijkstra(graph, source); // Complexity : O(ElogV + VlogV)
    }

    private void dijkstra(_2_EdgeWeightedDirectedGraph graph, int source) {
        distTo[source] = 0;
        tripletsForVertex[source] = new Triplet(counter++, distTo[source], source);
        treeSet.add(tripletsForVertex[source]);

        while (!treeSet.isEmpty()) {
            Triplet smallestTriplet = treeSet.pollFirst(); // Complexity : O(logV)
            for (_1_DirectedEdge edge : graph.adj(smallestTriplet.vertex)) {
                relaxEdge(edge); // O(logV)
            }
        }
        // Frequency to call treeSet.pollFirst() = V  => total complexity = O(VlogV)
        // Frequency to call relaxEdge(edge) = E => total complexity = O(ElogV)
    }

    private void relaxEdge(_1_DirectedEdge edge) {
        int src = edge.from();
        int dest = edge.to();
        if (distTo[dest] == -1 || distTo[dest] > distTo[src] + edge.getWeight()) {
            distTo[dest] = distTo[src] + edge.getWeight();
            parent[dest] = edge;
            if (tripletsForVertex[dest] != null) {
                treeSet.remove(tripletsForVertex[dest]); // Complexity : O(logV)
            }
            tripletsForVertex[dest] = new Triplet(counter++, distTo[dest], dest);
            treeSet.add(tripletsForVertex[dest]); // Complexity : O(logV)
        }
    }

    private void checkNonNegativeWeights(_2_EdgeWeightedDirectedGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (_1_DirectedEdge edge : graph.adj(i)) {
                if (edge.getWeight() < 0) {
                    throw new IllegalArgumentException("Graph contains negative weights, Dijkstra's cant be applied.");
                }
            }
        }
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo(v) != -1;
    }

    public Iterable<_1_DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<_1_DirectedEdge> stack = new LinkedList<>();
        for (_1_DirectedEdge e = parent[v]; e != null; e = parent[e.from()]) {
            stack.addFirst(e);
        }
        return stack;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= distTo.length) {
            throw new IllegalArgumentException("Illegal vertex index");
        }
    }
}

// Time Complexity : O(ElogV + VlogV) ~ O(ElogV)
// Space Complexity : O(V)

class Triplet implements Comparable<Triplet> {
    public int id;
    public double weight;
    public int vertex;

    public Triplet(int id, double weight, int vertex) {
        this.id = id;
        this.weight = weight;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Triplet o) {
        if (this.weight == o.weight)
            return Integer.compare(this.id, o.id);
        return Double.compare(this.weight, o.weight);
    }
}
