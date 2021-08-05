package _14_graphs._3_edge_weighted_undirected;

public class EdgeWeightedUndirectedGraphMain {
    public static void main(String[] args) {
        _2_EdgeWeightedUndirectedGraph graph = new _2_EdgeWeightedUndirectedGraph(9);
        graph.addEdge(new _1_Edge(0,1,4));
        graph.addEdge(new _1_Edge(0,7,8));
        graph.addEdge(new _1_Edge(1,2,8));
        graph.addEdge(new _1_Edge(1,7,11));
        graph.addEdge(new _1_Edge(2,8,2));
        graph.addEdge(new _1_Edge(2,3,7));
        graph.addEdge(new _1_Edge(2,5,4));
        graph.addEdge(new _1_Edge(3,4,9));
        graph.addEdge(new _1_Edge(3,5,14));
        graph.addEdge(new _1_Edge(4,5,10));
        graph.addEdge(new _1_Edge(5,6,2));
        graph.addEdge(new _1_Edge(6,8,6));
        graph.addEdge(new _1_Edge(6,7,1));
        graph.addEdge(new _1_Edge(7,8,7));

        _3_LazyPrimsAlgoForMST primsAlgoForMST = new _3_LazyPrimsAlgoForMST(graph);
        System.out.println("MST using Prim's Algo is :");
        System.out.println(primsAlgoForMST.getMST());
        System.out.println("MST weight using Prim's Algo = " + primsAlgoForMST.getWeight());

        _5_KruskalAlgoForMST kruskalAlgoForMST = new _5_KruskalAlgoForMST(graph);
        System.out.println("MST using Kruskal's Algo is :");
        System.out.println(kruskalAlgoForMST.getMST());
        System.out.println("MST weight using Kruskal's Algo = " + kruskalAlgoForMST.getWeight());

    }
}
