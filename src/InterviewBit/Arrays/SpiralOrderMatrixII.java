package InterviewBit.Arrays;
import java.util.*;

public class SpiralOrderMatrixII {
    public static void main(String[] args){
        SpiralOrderMatrixII a = new SpiralOrderMatrixII();
        ArrayList<ArrayList<Integer>> ans = a.solve2(3);
        for(ArrayList<Integer> b : ans)
            System.out.println(b);
    }

    public ArrayList<ArrayList<Integer>> solve2(int A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] arr = new int[A][A];

        int row = 0; int col = 0; int n = A; int m = A;
        int N = A * A;
        int K = 1;

        while(K <=N){
            for (int i = col; i < m; i++){
                arr[row][i] = K;
                K++;
            }
            row++;

            for(int i = row; i < n ; i++){
                arr[i][m-1] = K;
                K++;
            }
            m--;

            for(int i = m-1; i>=col; i--){
                arr[n-1][i] = K;
                K++;
            }
            n--;

            for(int i = n-1 ; i >= row ; i-- ){
                arr[i][col] = K;
                K++;
            }
            col++;

        }
        for(int i = 0; i < arr.length; i++){
            ArrayList<Integer> B = new ArrayList<>();
            for(int j = 0; j < arr[0].length ; j++){
                B.add(arr[i][j]);
            }
            ans.add(B);
        }

        return ans;
    }
    // Below solution is where matrix starts with A square
    public ArrayList<ArrayList<Integer>> solve(int A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] arr = new int[A][A];

        int row = 0; int col = 0; int n = A; int m = A;
        int N = A * A;

        while(N>0){
            for (int i = col; i < m; i++){
                arr[row][i] = N;
                N--;
            }
            row++;

            for(int i = row; i < n ; i++){
                arr[i][m-1] = N;
                N--;
            }
            m--;

            for(int i = m-1; i>=col; i--){
                arr[n-1][i] = N;
                N--;
            }
            n--;

            for(int i = n-1 ; i >= row ; i-- ){
                arr[i][col] = N;
                N--;
            }
            col++;

        }
        for(int i = 0; i < arr.length; i++){
            ArrayList<Integer> B = new ArrayList<>();
            for(int j = 0; j < arr[0].length ; j++){
                B.add(arr[i][j]);
            }
            ans.add(B);
        }

      return ans;
    }


}
