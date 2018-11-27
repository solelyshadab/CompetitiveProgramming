package CourseEra.Month3.PrimsMST;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjListArray[];
    // For Shortest Path Algorithm
    HashMap<Integer, Integer> edgeSizeMap[];



    // constructor
    Graph(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        edgeSizeMap = new HashMap[V];


        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 1; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
            edgeSizeMap[i] = new HashMap<>();
        }
    }
}
