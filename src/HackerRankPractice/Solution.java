package HackerRankPractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int diagonalDifference(int[][] a) {
        // Complete this function
        int totalSum=0;
        int j=a.length-1;
        for(int i=0;i<a.length;i++){
            totalSum=a[i][i]-a[j][i]+totalSum;
            j--;
        }

        return Math.abs(totalSum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(a));
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();;
    }
}
