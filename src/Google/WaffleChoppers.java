package Google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WaffleChoppers {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int R = in.nextInt();
            int C = in.nextInt();
            int H = in.nextInt();
            int V = in.nextInt();
            String[][] arr = new String[R][C];

            for(int x = 0; x < R; x++){
                for(int y = 0; y < C; y++){
                    arr[x][y] = in.next();
                }
            }
        String ans = isPossible(arr,R,C, H, V);
            System.out.println("Case #" + i + ": " + ans);

        }
    }

    public static String isPossible(String[][] arr,int R, int C, int H, int V){
        String ans ="IMPOSSIBLE";

        int nRow = R / H;
        int nCol = C / V;

        int maxSizeR = R-H;
        int maxSizeC = C-V;



        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){

            }
        }

        return ans;
    }
}
