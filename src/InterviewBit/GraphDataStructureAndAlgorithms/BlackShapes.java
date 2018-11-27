package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class BlackShapes {
    public static void main(String[] args) {
        BlackShapes a = new BlackShapes();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("OOOXOOO", "OOXXOXO", "OXOOOXO"));
        System.out.println(a.black(A));
    }

    public int black(ArrayList<String> A) {
        int n = A.size(); int m = A.get(0).length();
        int count = 0;
        boolean[][] isVisited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(!isVisited[i][j] && A.get(i).charAt(j)== 'X'){
                    BFS(A,i,j,isVisited,n,m);
                    count++;
                }
            }
        }

        return count;
    }

    public void BFS(ArrayList<String> A, int i, int j, boolean[][] isVisited,
                    int n, int m){
        Queue<int[]> q = new LinkedList<>();
        int[] arr = {i,j};
        q.add(arr);
        isVisited[i][j] = true;

        while(!q.isEmpty()){
            int[] point = q.poll();
            int x = point[0]; int y = point[1];

            if(isValid(A, x+1, y, n,m, isVisited)){
                isVisited [x+1][y]= true;
                int[] next = {x+1, y};
                q.add(next);
            }

            if(isValid(A, x-1, y, n,m, isVisited)){
                isVisited [x-1][y]= true;
                int[] next = {x-1, y};
                q.add(next);
            }
            if(isValid(A, x, y+1, n,m, isVisited)){
                isVisited [x][y+1]= true;
                int[] next = {x, y+1};
                q.add(next);
            }
            if(isValid(A, x, y-1, n,m, isVisited)){
                isVisited [x][y-1]= true;
                int[] next = {x, y-1};
                q.add(next);
            }
        }

    }

    private boolean isValid(ArrayList<String> A, int i, int j, int n, int m, boolean[][] isVisited){
        return(i >=0 && i < n && j >=0 && j < m
                &&!isVisited[i][j] && A.get(i).charAt(j) == 'X');
    }

}
