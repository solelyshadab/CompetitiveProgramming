package CourseEra.Month2.GraphSearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DijkstraGraphShortestPath {
    List<Integer> X = new ArrayList<>();
    int wStar;
    int vStar;

    public static void main(String args[]) {

        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/GraphShortestPath_LargeInputData.txt");
        DijkstraGraphShortestPath dijkstraGraphShortestPath = new DijkstraGraphShortestPath();
        Graph graph = new Graph(201);
        dijkstraGraphShortestPath.loadGraphData(graph, file);
        dijkstraGraphShortestPath.dijkstraLoop(graph);
        //System.out.println(Arrays.toString(graph.shortestPathArray));
        System.out.println(graph.shortestPathArray[7]);
        System.out.println(graph.shortestPathArray[37]);
        System.out.println(graph.shortestPathArray[59]);
        System.out.println(graph.shortestPathArray[82]);
        System.out.println(graph.shortestPathArray[99]);
        System.out.println(graph.shortestPathArray[115]);
        System.out.println(graph.shortestPathArray[133]);
        System.out.println(graph.shortestPathArray[165]);
        System.out.println(graph.shortestPathArray[188]);
        System.out.println(graph.shortestPathArray[197]);
    }

    private void dijkstraLoop(Graph graph){
        X.add(1);
        graph.shortestPathArray[1] = 0;

        while (X.size() < graph.V-1){
            int totalPath = Integer.MAX_VALUE;

            //Loop for vertices in X
            for(int i = 0; i< X.size();i++){
                //Loop for edges in each Vertice of X
                for(int j = 0; j< graph.adjListArray[X.get(i)].size(); j++){

                    int w = graph.adjListArray[X.get(i)].get(j);
                    if(!X.contains(w)){
                        if( graph.shortestPathArray[X.get(i)] + graph.edgeSizeMap[X.get(i)].get(w) < totalPath) {
                            totalPath = graph.shortestPathArray[X.get(i)] + graph.edgeSizeMap[X.get(i)].get(w);
                            wStar = w;
                            vStar = X.get(i);
                        }
                    }
                }
            }

            X.add(wStar);
            graph.shortestPathArray[wStar] = totalPath;
            //Add edges of VStar to wStarShortestPathEdgesArray
            setShortestPathEdgesofWstar(graph, wStar, vStar);
        }
    }

    private void setShortestPathEdgesofWstar(Graph graph, int wStar, int vStar){
        if(graph.shortestPathEdgesArray[vStar].size()>0) {
            for (int k = 0; k < graph.shortestPathEdgesArray[vStar].size(); k++) {
                int edgeofVStar = graph.shortestPathEdgesArray[vStar].get(k);
                graph.shortestPathEdgesArray[wStar].addFirst(edgeofVStar);
            }
        }
    }


    private void loadGraphData(Graph graph, File file){

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {

                String verticeLine = scanner.nextLine();
                int vertice = Integer.parseInt(verticeLine.substring(0, verticeLine.indexOf('\t')));
                String edgeNsizes = verticeLine.substring(verticeLine.indexOf('\t') + 1);
                if (edgeNsizes != null) {
                    for (String edgeNsize : edgeNsizes.split("\t")) {

                        int edge = Integer.parseInt(edgeNsize.substring(0, edgeNsize.indexOf(',')));
                        int size = Integer.parseInt(edgeNsize.substring(edgeNsize.indexOf(',') + 1));

                        addEdge(graph, vertice, edge);
                        addEdgeSize(graph, vertice, edge, size);
                    }
                }
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void addEdge(Graph graph, int src, int dest)
    {
        // Add an edge from src to dest.
        graph.adjListArray[src].addFirst(dest);
    }

    static void addEdgeSize(Graph graph,int vertice, int edge, int size)
    {
        graph.edgeSizeMap[vertice].put(edge, size);
    }

}
