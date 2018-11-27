package InterviewBit.DynamicProgramming.MatrixDP;

import InterviewBit.DynamicProgramming.Practice.LongestCommonSubsequence;

import java.util.*;

public class MinSumPathInMatrix {
    public static void main(String[] args){
        MinSumPathInMatrix a = new MinSumPathInMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(4,8,2));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(1,5,3));
        A.add(B);A.add(C);A.add(D);
        System.out.println(a.minSum(A));

    }

    public int minSum(ArrayList<ArrayList<Integer>> A){
        int[][] memo = new int[A.size()][A.get(0).size()];

        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length;j++){
                if(i==0 && j ==0)
                    memo[i][j] = A.get(i).get(j);

                 else if(i==0)
                    memo[i][j] = memo[i][j-1] + A.get(i).get(j);

                else if(j==0)
                    memo[i][j] = memo[i-1][j] + A.get(i).get(j);

                else{
                    int case1 = memo[i-1][j-1] + A.get(i).get(j);
                    int case2 = memo[i][j-1] + A.get(i).get(j);
                    int case3 = memo[i-1][j] + A.get(i).get(j);

                    memo[i][j] = Math.min(Math.min(case1,case2), case3);
                }

            }
        }

        LongestCommonSubsequence.printTable(memo);
        return memo[A.size()-1][A.get(0).size()-1];
    }




}
