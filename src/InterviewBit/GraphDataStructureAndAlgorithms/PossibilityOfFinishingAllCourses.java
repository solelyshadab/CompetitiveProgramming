package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class PossibilityOfFinishingAllCourses {
    public static void main(String[] args){
        PossibilityOfFinishingAllCourses a = new PossibilityOfFinishingAllCourses();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,3,4,5));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2,1,5,3));
        System.out.println(a.solve(5,B,C));
    }

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList vertices[] = new ArrayList[A+1];

        for(int i = 0; i < B.size(); i++){
            int u = B.get(i);
            int v = C.get(i);

            if(vertices[u] !=null)
                vertices[u].add(v);
            else {
                vertices[u] = new ArrayList<>();
                vertices[u].add(v);
            }

        }
        int[] visited = new int[A+1];
        for(int i = 1; i <= A ; i++){
            if(visited[i] ==0 && hasCircles(i,visited, vertices))
                return 0;
        }
        return 1;

    }
    // Solution1: Using BFS for cycle detection
    private boolean hasCircles(int s, int[] visited, ArrayList[] vertices) {
        Queue<Integer> queue = new LinkedList<>();
        // For undirected graph, create parent[] array and initialize to -1
        Arrays.fill(visited,0);

        queue.add(s);
        visited[s] = 1;
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(vertices[u] == null)
                continue;
            ArrayList<Integer> list = vertices[u];
            for(Integer v : list){

                if(visited[v] == 0){
                    queue.add(v);
                    visited[v] = 1;
                    // for undirected, set parent[v] = u;
                }
                // If it's undirected graph we need to check parent[u] != v, if yes then cyclic
                else {
                    return true;
                }
            }
        }

        return false;
    }
    //Solution 2: Uses Map for graph, and DFS to find cyclic
    public int solve1(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();


        for(int i = 0; i < B.size(); i++){
            int u = C.get(i);
            int v = B.get(i);

            if(map.containsKey(u))
                map.get(u).add(v);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                map.put(u, list);
            }

        }

        int[] visited = new int[A+1];
        for(int i = 1; i <= A ; i++){
            if(hasCircles(i,visited, map))
                return 0;
        }


        return 1;

    }

    private boolean hasCircles(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
        if (visited[vertexId] == -1) {
            return true;
        }

        if (visited[vertexId] == 1) {
            return false;
        }

        visited[vertexId] = -1;

        List<Integer> neighbors = adjList.get(vertexId);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (hasCircles(neighbor, visited, adjList)) {
                    return true;
                }
            }
        }

        visited[vertexId] = 1;

        return false;
    }
}
