package _14_graphs._4_edge_weighted_directed;

public class _1_DirectedEdge implements Comparable<_1_DirectedEdge> {

    private final double weight;
    private final int src;
    private final int dest;

    public _1_DirectedEdge(int src, int dest, double weight) {
        if (src < 0 || dest < 0 || Double.isNaN(weight)) {
            throw new IllegalArgumentException("Illegal arguments for DirectedEdge");
        }
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int from() {
        return src;
    }

    public int to() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(_1_DirectedEdge o) {
        return Double.compare(weight, o.getWeight());
    }

    @Override
    public String toString() {
        return src + "-->" + dest + " " + weight;
    }
}
