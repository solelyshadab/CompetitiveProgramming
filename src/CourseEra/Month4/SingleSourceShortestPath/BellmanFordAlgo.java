package CourseEra.Month4.SingleSourceShortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class BellmanFordAlgo {
    public static void main(String[] args) {
        BellmanFordAlgo bellmanFordAlgo = new BellmanFordAlgo();
        Graph graph = bellmanFordAlgo.loadGraph(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/SSSP_SmallData.txt"));
        int ans = bellmanFordAlgo.findShortestPath(graph);
        if (ans == -1)
            System.out.println("Negative Cycle");
        else
            System.out.println(ans);
    }

    private int findShortestPath(Graph graph){
        int A[][] = new int[graph.V][graph.V];
        A[0][1] = 0;
        for(int i =2; i < graph.V; i++) {
            A[0][i] = Integer.MAX_VALUE;
        }
    for(int i = 1; i < graph.V; i++){
        for(int v = 1; v < graph.V ; v++){
           int case1 = A[i-1][v];
           int case2 = Integer.MAX_VALUE;
           for(Map.Entry<Integer, Integer> entry : graph.inDegreeVerticesMap[v].entrySet()){
               Integer w = entry.getKey();
               Integer Cwv = entry.getValue();

               if(A[i-1][w] != Integer.MAX_VALUE && A[i-1][w] + Cwv < case2){
                   case2 = A[i-1][w] + Cwv;
               }
           }

           A[i][v] = Math.min(case1, case2);
        }
    }
    //Check for negative cycle
        for(int v =0; v < graph.V ; v++){
            if(A[graph.V-2][v] != A[graph.V-1][v] )
                return -1;
        }
    return A[graph.V-1][graph.V-1];
    }

    private Graph loadGraph(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int totalVertices = scanner.nextInt();
            int totaledges = scanner.nextInt();
            Graph graph = new Graph(totalVertices + 1);

            while (scanner.hasNext()) {

                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                int edgeCost = scanner.nextInt();

                addEdge(graph, src, dest);
                addEdgeSize(graph, src, dest, edgeCost);
            }
            scanner.close();
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].addFirst(dest);
    }

    private static void addEdgeSize(Graph graph, int vertice, int edge, int size) {
        graph.edgeSizeMap[vertice].put(edge, size);
        //Add to in-degree Vertice Map
        graph.inDegreeVerticesMap[edge].put(vertice,size);
    }
}
