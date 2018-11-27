package CourseEra.Month2.GraphSearch;

import CourseEra.Month1.MergeSort;
import HackerRankPractice.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphSCCs {
    private static int current_label;
    private static int t;
    private static int s0;
    // Adds an edge to an undirected graph
    static void addEdge(Graph graph, int src, int dest)
    {
        //graph.createLinkedListforthisV(src);
        //graph.adjListArray[src] = new LinkedList<>();
        // Add an edge from src to dest.
        graph.adjListArray[src].addFirst(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        //graph.adjListArray[dest].addFirst(src);
    }

    static void printGraph(Graph graph)
    {
        for(int v = 1; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ (v));
            System.out.print("head");
            for(Integer pCrawl: graph.adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        Graph graph = new Graph(875715);
        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/GraphSCCs_LargeInputData.txt");
        addEdges(graph, file);
         Graph revGraph = new Graph(875715);
         createRevGraph(graph, revGraph);
         DFSLoop(revGraph);
        Graph finalGraph = new Graph(875715);
        createFinalGraph(revGraph, finalGraph);
        DFSLoop(finalGraph);
       CountFrequencies countFrequencies = new CountFrequencies();
       int[] result =  countFrequencies.findCounts(finalGraph.leaderArray, finalGraph.leaderArray.length);
        MergeSort mergeSort = new MergeSort();
       int[] arr = mergeSort.sort(result,0, result.length-1);
        for(int i =arr.length-1; i > arr.length - 6;i--){
           System.out.println(arr[i]);
       }

        // print the adjacency list representation of
        // the above graph
        //printGraph(graph);
        //printGraph(revGraph);
    }

    private static void createFinalGraph(Graph revGraph, Graph finalGraph){

        for(int v = 1; v < revGraph.finishingtimeArray.length; v++){

            int ft = revGraph.finishingtimeArray[v];

            for(Integer pCrawl: revGraph.adjListArray[v]){
                int src = revGraph.finishingtimeArray[pCrawl];
                //add edges in reverse way
                addEdge(finalGraph, src, ft);
            }
        }
    }


    private static void DFSLoop(Graph graph){
        t=0;
        for(int i =graph.V-1; i>0;i--){
            if(!graph.isExploredArray[i]){
                s0 = i;
                DFS(graph, i);
            }
        }
    }

    private static void DFS(Graph graph, int s){
        graph.isExploredArray[s] = true;
        graph.leaderArray[s] = s0;

        for(int i = 0; i < graph.adjListArray[s].size(); i++){

            int v = graph.adjListArray[s].get(i);
            if(!graph.isExploredArray[v])
                DFS(graph,v);
        }

        t++;
        graph.finishingtimeArray[s] = t;
    }

//    private static void DFSLoop(Graph graph){
//        current_label = graph.V-1;
//        for(int v =1; v< graph.V;v++){
//            if(!graph.isExploredArray[v])
//                DFS(graph, v);
//        }
//    }



    private static void createRevGraph(Graph graph, Graph revGraph){
        for(int v = 1; v < graph.V; v++)
        {
            int dest = v;
            for(Integer pCrawl: graph.adjListArray[v]){
                int src = pCrawl;
                addEdge(revGraph, src, dest);
            }
        }

    }

    public static void addEdges(Graph graph, File file){

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){

                int src =scanner.nextInt();
                int dest =scanner.nextInt();

                addEdge(graph,src,dest);

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
