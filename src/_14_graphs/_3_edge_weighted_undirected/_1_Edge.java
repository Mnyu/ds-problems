package _14_graphs._3_edge_weighted_undirected;

public class _1_Edge implements Comparable<_1_Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public _1_Edge(int v, int w, double weight) {
        if (v < 0 || w < 0 || Double.isNaN(weight)) {
            throw new IllegalArgumentException("Illegal edge arguments");
        }
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int x) {
        if (v == x)
            return w;
        else if (w == x)
            return v;
        else throw new IllegalArgumentException("Invalid vertex index");
    }

    @Override
    public int compareTo(_1_Edge o) {
        return Double.compare(this.weight, o.getWeight());
    }

    @Override
    public String toString() {
        return v + "---" + w + " " + weight;
    }
}
