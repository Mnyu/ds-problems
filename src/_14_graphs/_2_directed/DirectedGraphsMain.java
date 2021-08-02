package _14_graphs._2_directed;

public class DirectedGraphsMain {
    public static void main(String[] args) {
        _1_DirectedGraph graph = new _1_DirectedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println("Directed Graph is :");
        System.out.println(graph);


        int source = 1;
        _2_BreadthFirstDirectedPaths bfsDirectedPaths = new _2_BreadthFirstDirectedPaths(graph, source);

        System.out.println("BFS : Shortest Paths from source vertex " + source + " : ");
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(i + "->" + bfsDirectedPaths.pathTo(i) + ", shortest distance : " + bfsDirectedPaths.distTo(i));
        }

        _3_DepthFirstDirectedPaths dfsDirectedPaths = new _3_DepthFirstDirectedPaths(graph, source);
        System.out.println("\nDFS : Paths from vertex " + source);
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(i + "->" + dfsDirectedPaths.pathTo(i));
        }

        _4_CycleDetectorDirected cycleDetectorDirected = new _4_CycleDetectorDirected();
        System.out.println();
        System.out.println("Directed Graph contains cycle : " + cycleDetectorDirected.isCyclePresent(graph));
    }
}
