package CourseEra.Month2.GraphSearch.BreadthFirstSearch;

import java.io.File;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args){
        Graph graph = new Graph(7);
        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/GraphBFS_SmallInput.txt");
        loadGraph(graph,file);
        BFS(graph);
        printGraph(graph);
    }

    private static void BFS(Graph graph){
        graph.isExploredArray[1] = true;
        graph.queueList.add(1);

        while (graph.queueList.size() > 0){
            int v = graph.queueList.get(0);
            graph.queueList.remove(0);
            for(int i = 0; i < graph.adjListArray[v].size(); i++){
                int w = graph.adjListArray[v].get(i);

                if(!graph.isExploredArray[w]){
                    graph.isExploredArray[w] = true;
                    graph.queueList.add(w);
                    graph.distanceIndex[w] = graph.distanceIndex[v] + 1;
                }
            }
        }
    }

    private static void loadGraph(Graph graph,File file) {
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                addEdge(graph,u,v);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void printGraph(Graph graph){
        for(int i = 1; i < graph.V ; i++) {
            System.out.println("Vertice : " + i + " --> DistanceIndex : " + graph.distanceIndex[i]);
        }
    }

    private static void addEdge(Graph graph,int u, int v){
        graph.adjListArray[u].addFirst(v);
        graph.adjListArray[v].addFirst(u);
    }
}
