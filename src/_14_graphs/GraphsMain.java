package _14_graphs;

public class GraphsMain {
    public static void main(String[] args) {
        Graph undirGraph = new Graph(7, false);
        undirGraph.addEdge(0, 1);
        undirGraph.addEdge(1, 2);
        undirGraph.addEdge(2, 3);
        undirGraph.addEdge(3, 5);
        undirGraph.addEdge(5, 6);
        undirGraph.addEdge(4, 5);
        undirGraph.addEdge(0, 4);
        undirGraph.addEdge(3, 4);
        System.out.println(undirGraph);

        int source = 1;
        BreadthFirstPaths bfsPaths = new BreadthFirstPaths(undirGraph, source);

        System.out.println("BFS : Shortest Paths from vertex " + source + " : ");
        for (int i = 0; i < undirGraph.vertices(); i++) {
            System.out.println(i + "->" + bfsPaths.pathTo(i) + ", shortest distance : " + bfsPaths.distTo(i));
        }

        DepthFirstPaths dfsPaths = new DepthFirstPaths(undirGraph, source);
        System.out.println("DFS : Paths from vertex " + source);
        for (int i = 0; i < undirGraph.vertices(); i++) {
            System.out.println(i + "->" + dfsPaths.pathTo(i));
        }

        CycleDetector cycleDetector = new CycleDetector();
        System.out.println();
        System.out.println("Undirected Graph contains cycle : " + cycleDetector.containsCycleUndirected(undirGraph));

        Graph dirGraph = new Graph(3, true);
        dirGraph.addEdge(0, 1);
        dirGraph.addEdge(1, 2);
        dirGraph.addEdge(2, 0);

        System.out.println();
        System.out.println("Directed Graph contains cycle : " + cycleDetector.containsCycle(dirGraph));

    }
}
