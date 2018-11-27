package CourseEra.Month3.PrimsMST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimsMSTUsingGraph {
    private List<Integer> X = new ArrayList<>();
    private int MSTCost;
    private int wStar;
    private int vStar;

    public static void main(String args[])
    {

        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/PrimsMST_LargeData.txt");
        PrimsMSTUsingGraph primsMSTUsingGraph = new PrimsMSTUsingGraph();
        Graph graph = addEdges( file);
        primsMSTUsingGraph.mainLoop(graph);
        System.out.println("MST Cost : "+ primsMSTUsingGraph.MSTCost);
    }

    private void mainLoop(Graph graph){
        X.add(1);

        while (X.size() < graph.V-1){
            int totalPath = 1000000;

            //Loop for vertices in X
            for(int i = 0; i< X.size();i++){
                //Loop for edges in each Vertice of X
                for(int j = 0; j< graph.adjListArray[X.get(i)].size(); j++){

                    int w = graph.adjListArray[X.get(i)].get(j);
                    if(!X.contains(w)){
                        int cost = graph.edgeSizeMap[X.get(i)].get(w);
                        if( cost < totalPath) {
                            totalPath = graph.edgeSizeMap[X.get(i)].get(w);
                            wStar = w;
                            vStar = X.get(i);

                        }
                    }
                }
            }
            MSTCost += totalPath;
            X.add(wStar);

        }
    }

    public static Graph addEdges( File file){

        try (Scanner scanner = new Scanner(file)) {
            int totalVertices = scanner.nextInt();
            int totalEdges = scanner.nextInt();
            Graph graph = new Graph(totalVertices + 1);

            while(scanner.hasNext()){

                int src =scanner.nextInt();
                int dest =scanner.nextInt();
                int edgeCost = scanner.nextInt();

                addEdge(graph,src,dest);
                addEdgeSize(graph,src,dest, edgeCost);
            }
            scanner.close();
            return graph;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void addEdge(Graph graph, int src, int dest)
    {
        graph.adjListArray[src].addFirst(dest);
        graph.adjListArray[dest].addFirst(src);
    }

    private static void addEdgeSize(Graph graph,int vertice, int edge, int size)
    {
        graph.edgeSizeMap[vertice].put(edge, size);
        graph.edgeSizeMap[edge].put(vertice, size);
    }

}
