package CourseEra.Month4.SingleSourceShortestPath;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjListArray[];
    HashMap<Integer, Integer> edgeSizeMap[];
    HashMap<Integer, Integer> inDegreeVerticesMap[];

    // constructor
    Graph(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];
        edgeSizeMap = new HashMap[V];
        inDegreeVerticesMap = new HashMap[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 1; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
            edgeSizeMap[i] = new HashMap<>();
            inDegreeVerticesMap[i] = new HashMap<>();
        }
    }
}
