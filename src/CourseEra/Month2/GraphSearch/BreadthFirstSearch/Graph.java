package CourseEra.Month2.GraphSearch.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    LinkedList<Integer>[] adjListArray;
    boolean[] isExploredArray;
    List<Integer> queueList;
    int[] distanceIndex;
    int V;

    public Graph(int V){
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i = 1; i < V; i++){
            adjListArray[i] = new LinkedList<>();
        }
        isExploredArray = new boolean[V];
        queueList = new ArrayList<>();
        distanceIndex = new int[V];
//        distanceIndex[1] = 0;
//        for(int i = 2; i < V ; i++){
//            distanceIndex[i] = Integer.MAX_VALUE;
//        }
    }
}
