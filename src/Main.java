public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        MyGraph<String> myGraph = new MyGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        myGraph.addEdge("Almaty", "Astana");
        myGraph.addEdge("Almaty", "Shymkent");
        myGraph.addEdge("Shymkent", "Astana");
        myGraph.addEdge("Astana", "Kostanay");
        myGraph.addEdge("Shymkent", "Kyzylorda");

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("\n--------------------------------");

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(myGraph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(myGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}

