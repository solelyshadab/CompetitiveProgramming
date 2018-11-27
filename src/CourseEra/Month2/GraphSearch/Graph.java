package CourseEra.Month2.GraphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int V;
    LinkedList<Integer> adjListArray[];
    boolean isExploredArray[];
    int[] finishingtimeArray;
    int leaderArray[];
    // For Shortest Path Algorithm
    HashMap<Integer, Integer> edgeSizeMap[];
    int[] shortestPathArray;
    LinkedList<Integer> shortestPathEdgesArray[];

    // constructor
    Graph(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];
        isExploredArray = new boolean[V];
        finishingtimeArray = new int[V];
        leaderArray = new int[V];
        edgeSizeMap = new HashMap[V];
        shortestPathArray = new int[V];
        shortestPathEdgesArray = new LinkedList[V];
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 1; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
            isExploredArray[i] = false;
            shortestPathArray[i] = 0;
            edgeSizeMap[i] = new HashMap<>();
            shortestPathEdgesArray[i] = new LinkedList<>();
        }
    }

}
