package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class KnightOnChessBoard {
    public static void main(String[] args){
        KnightOnChessBoard a = new KnightOnChessBoard();
        System.out.println(a.isPossible(8,8,0,1,0,1));

    }

    public int isPossible(int n, int m, int x1, int x2, int y1, int y2){
        boolean[][] isVisited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
       
        int[] startArr = {x1,y1};
        queue.add(startArr);
        isVisited[x1][y1] = true;

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            if(isStep(x+1,y+2,n,m) && !isVisited[x+1][y+2]){
                int[] arr1 = {x+1, y+2};

                queue.add(arr1);
            }
            if(isStep(x+1,y-2,n,m) && !isVisited[x+1][y-2]){
                int[] arr1 = {x+1,y-2};
                isVisited[x+1][y-2] = true;
                queue.add(arr1);
            }
            if(isStep(x-1,y+2,n,m) && !isVisited[x-1][y+2]){
                int[] arr1 = {x-1,y+2};
                isVisited[x-1][y+2] = true;
                queue.add(arr1);
            }
            if(isStep(x-1,y-2,n,m) && !isVisited[x-1][y-2]){
                int[] arr1 = {x-1,y-2};
                isVisited[x-1][y-2] = true;
                queue.add(arr1);
            }
            if(isStep(x+2,y+1,n,m) && !isVisited[x+2][y+1]){
                int[] arr1 = {x+2,y+1};
                isVisited[x+2][y+1] = true;
                queue.add(arr1);
            }
            if(isStep(x-2,y+1,n,m) && !isVisited[x-2][y+1]){
                int[] arr1 = {x-2,y+1};
                isVisited[x-2][y+1] = true;
                queue.add(arr1);
            }
            if(isStep(x+2,y-1,n,m) && !isVisited[x+2][y-1]){
                int[] arr1 = {x+2, y-1};
                isVisited[x+2][y-1] = true;
                queue.add(arr1);
            }
            if(isStep(x-2,y-1,n,m) && !isVisited[x-2][y-1]){
                int[] arr1 = {x-2,y-1};
                isVisited[x-2][y-1] = true;
                queue.add(arr1);
            }


        }

        if(isVisited[n-1][m-1])
            return 1;

        return 0;
    }

    private boolean isStep(int x, int y, int n, int m){

        return (x<n && x>=0 && y < m && y >=0 );
    }
}
