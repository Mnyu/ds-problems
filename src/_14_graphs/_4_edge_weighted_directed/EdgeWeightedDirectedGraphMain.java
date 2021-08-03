package _14_graphs._4_edge_weighted_directed;

public class EdgeWeightedDirectedGraphMain {

    public static void main(String[] args) {
        _2_EdgeWeightedDirectedGraph graph = new _2_EdgeWeightedDirectedGraph(9);
        graph.addEdge(new _1_DirectedEdge(0, 1, 4));
        graph.addEdge(new _1_DirectedEdge(0, 7, 8));
        graph.addEdge(new _1_DirectedEdge(1, 2, 8));
        graph.addEdge(new _1_DirectedEdge(1, 7, 11));
        graph.addEdge(new _1_DirectedEdge(2, 8, 2));
        graph.addEdge(new _1_DirectedEdge(2, 3, 7));
        graph.addEdge(new _1_DirectedEdge(2, 5, 4));
        graph.addEdge(new _1_DirectedEdge(3, 4, 9));
        graph.addEdge(new _1_DirectedEdge(3, 5, 14));
        graph.addEdge(new _1_DirectedEdge(4, 5, 10));
        graph.addEdge(new _1_DirectedEdge(5, 6, 2));
        graph.addEdge(new _1_DirectedEdge(6, 8, 6));
        graph.addEdge(new _1_DirectedEdge(6, 7, 1));
        graph.addEdge(new _1_DirectedEdge(7, 8, 7));

        _3_DijkstrasAlgo dijkstrasAlgo = new _3_DijkstrasAlgo(graph, 0);
        System.out.println("Shortest Paths using Dijkstra's Algo graph 1:");
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println("Node : " + i + " Distance :" + dijkstrasAlgo.distTo(i) + "  Path : " + dijkstrasAlgo.pathTo(i));
        }

        _2_EdgeWeightedDirectedGraph graph2 = new _2_EdgeWeightedDirectedGraph(6);
        graph2.addEdge(new _1_DirectedEdge(0, 1, 4));
        graph2.addEdge(new _1_DirectedEdge(0, 2, 2));
        graph2.addEdge(new _1_DirectedEdge(1, 2, 5));
        graph2.addEdge(new _1_DirectedEdge(1, 4, 10));
        graph2.addEdge(new _1_DirectedEdge(2, 3, 3));
        graph2.addEdge(new _1_DirectedEdge(3, 4, 4));
        graph2.addEdge(new _1_DirectedEdge(4, 5, 11));

        dijkstrasAlgo = new _3_DijkstrasAlgo(graph2, 0);
        System.out.println("\nShortest Paths using Dijkstra's Algo graph 2:");
        for (int i = 0; i < graph2.getVertices(); i++) {
            System.out.println("Node : " + i + " Distance :" + dijkstrasAlgo.distTo(i) + "  Path : " + dijkstrasAlgo.pathTo(i));
        }

        _2_EdgeWeightedDirectedGraph graph3 = new _2_EdgeWeightedDirectedGraph(3);
        graph3.addEdge(new _1_DirectedEdge(0, 1, 1));
        graph3.addEdge(new _1_DirectedEdge(0, 2, 1));
        graph3.addEdge(new _1_DirectedEdge(2, 0, 1));
        graph3.addEdge(new _1_DirectedEdge(1, 2, 1));

        dijkstrasAlgo = new _3_DijkstrasAlgo(graph3, 0);
        System.out.println("\nShortest Paths using Dijkstra's Algo graph 2:");
        for (int i = 0; i < graph3.getVertices(); i++) {
            System.out.println("Node : " + i + " Distance :" + dijkstrasAlgo.distTo(i) + "  Path : " + dijkstrasAlgo.pathTo(i));
        }

        _2_EdgeWeightedDirectedGraph graph4 = new _2_EdgeWeightedDirectedGraph(8);
        graph4.addEdge(new _1_DirectedEdge(0, 1, 4));
        graph4.addEdge(new _1_DirectedEdge(0, 7, 4));
        graph4.addEdge(new _1_DirectedEdge(0, 4, 4));
        graph4.addEdge(new _1_DirectedEdge(1, 2, 4));
        graph4.addEdge(new _1_DirectedEdge(1, 3, 4));
        graph4.addEdge(new _1_DirectedEdge(1, 7, 4));
        graph4.addEdge(new _1_DirectedEdge(2, 6, 4));
        graph4.addEdge(new _1_DirectedEdge(3, 6, 4));
        graph4.addEdge(new _1_DirectedEdge(4, 6, 4));
        graph4.addEdge(new _1_DirectedEdge(4, 7, 4));
        graph4.addEdge(new _1_DirectedEdge(5, 2, 4));
        graph4.addEdge(new _1_DirectedEdge(5, 6, 4));
        graph4.addEdge(new _1_DirectedEdge(7, 5, 4));
        graph4.addEdge(new _1_DirectedEdge(7, 2, 4));

        _4_TopologicalSortShortestPaths topoSortSPs = new _4_TopologicalSortShortestPaths(graph4, 0);
        System.out.println("\nShortest Paths using Topo Sort Algo graph 2 source 0 :");
        for (int i = 0; i < graph4.getVertices(); i++) {
            System.out.println("Node : " + i + " Distance :" + topoSortSPs.distTo(i) + "  Path : " + topoSortSPs.pathTo(i));
        }

        topoSortSPs = new _4_TopologicalSortShortestPaths(graph4, 6);
        System.out.println("\nShortest Paths using Topo Sort Algo graph 2 source 6:");
        for (int i = 0; i < graph4.getVertices(); i++) {
            System.out.println("Node : " + i + " Distance :" + topoSortSPs.distTo(i) + "  Path : " + topoSortSPs.pathTo(i));
        }

        topoSortSPs = new _4_TopologicalSortShortestPaths(graph4, 1);
        System.out.println("\nShortest Paths using Topo Sort Algo graph 2 source 1:");
        for (int i = 0; i < graph4.getVertices(); i++) {
            System.out.println("Node : " + i + " Distance :" + topoSortSPs.distTo(i) + "  Path : " + topoSortSPs.pathTo(i));
        }

    }
}
