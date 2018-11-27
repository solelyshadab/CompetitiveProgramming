package CourseEra.Month4.AllPairShortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FloydWarshallAlgo {
    public static void main(String[] args) {
        FloydWarshallAlgo floydWarshallAlgo = new FloydWarshallAlgo();
        Graph graph = floydWarshallAlgo.loadGraph(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/APSP_Large3.txt"));
        int ans = floydWarshallAlgo.findshortestPath(graph);
        if (ans == -1)
            System.out.println("Negative Cycle");
        else
            System.out.println(ans);
    }

    private int findshortestPath(Graph graph) {

        int A[][][] = new int[graph.V][graph.V][graph.V];
        //Base Case
        for(int i = 1; i < graph.V; i++){
            for(int j = 1; j < graph.V; j++){
                if(i==j) {
                    A[i][j][0] = 0;
                    continue;
                }
                if(graph.adjListArray[i].contains(j)){
                    A[i][j][0] = graph.edgeSizeMap[i].get(j);
                    continue;
                }
                A[i][j][0] = Integer.MAX_VALUE;
            }
        }
        //Main Loop
        for(int k =1; k < graph.V; k++){
            for(int i = 1; i < graph.V; i++){
                for(int j =1; j< graph.V; j++){
                    int case1 = A[i][j][k-1];
                    int case2;
                    if(A[i][k][k-1] == Integer.MAX_VALUE ||  A[k][j][k-1] == Integer.MAX_VALUE) {
                        case2 = Integer.MAX_VALUE;
                    }
                    else {
                        case2 = A[i][k][k - 1] + A[k][j][k - 1];
                    }
                    A[i][j][k] = Math.min(case1,case2);
                }
            }
        }

        //Check for negative cycles
        for(int i = 1; i < graph.V; i++){
            for(int n =0; n< graph.V; n++){
                if(A[i][i][n] < 0){
                    return -1;
                }
            }
        }
int ans = Integer.MAX_VALUE;
        for(int i = 1; i < graph.V; i++){
            for(int j = 1; j< graph.V; j++){
                if(A[i][j][graph.V-1] < ans){
                    ans = A[i][j][graph.V-1];
                }
            }
        }
        return ans;

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
    }
}
