package _14_graphs._1_undirected;

public class UndirectedGraphsMain {
    public static void main(String[] args) {
        _1_UndirectedGraph graph = new _1_UndirectedGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 5);
        graph.addEdge(0, 4);
        graph.addEdge(3, 4);
        System.out.println("Undirected Graph is :");
        System.out.println(graph);

        int source = 1;
        _2_BreadthFirstPaths bfsPaths = new _2_BreadthFirstPaths(graph, source);

        System.out.println("BFS : Shortest Paths from source vertex " + source + " : ");
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(i + "->" + bfsPaths.pathTo(i) + ", shortest distance : " + bfsPaths.distTo(i));
        }

        _3_DepthFirstPaths dfsPaths = new _3_DepthFirstPaths(graph, source);
        System.out.println("\nDFS : Paths from vertex " + source);
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(i + "->" + dfsPaths.pathTo(i));
        }

        _4_CycleDetector cycleDetector = new _4_CycleDetector();
        System.out.println();
        System.out.println("Undirected Graph contains cycle : " + cycleDetector.isCyclePresent(graph));


        _1_UndirectedGraph graph2 = new _1_UndirectedGraph(13);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 5);
        graph2.addEdge(0, 6);
        graph2.addEdge(3, 5);
        graph2.addEdge(3, 4);
        graph2.addEdge(4, 5);
        graph2.addEdge(4, 6);
        graph2.addEdge(7, 8);
        graph2.addEdge(9, 10);
        graph2.addEdge(9, 11);
        graph2.addEdge(9, 12);
        graph2.addEdge(11, 12);
        _5_ConnectedComponents connectedComp = new _5_ConnectedComponents(graph2);
        System.out.println("\nConnected Components : " + connectedComp.getNoOfConnectedComponents());
        for (int i = 0; i < graph2.getVertices(); i++) {
            System.out.println("Vertex : " + i + " CompId -> " + connectedComp.getComponentId(i));
        }
        System.out.println("\nSize of Connected Components : ");
        for (int i = 0; i < connectedComp.getNoOfConnectedComponents(); i++) {
            System.out.println("Comp Id : " + i + " Size : " + connectedComp.getComponentSize(i));
        }
    }
}
