package InterviewBit.DynamicProgramming.MatrixDP;

import InterviewBit.DynamicProgramming.Practice.LongestCommonSubsequence;

import java.util.*;

public class UniquePathsInGrid {
    public static void main(String[] args) {
        UniquePathsInGrid a = new UniquePathsInGrid();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(0, 0, 0));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(0, 1, 0));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(0, 0, 0));
        A.add(B);A.add(C);A.add(D);
        System.out.println(a.paths(A));

    }

    public int paths(ArrayList<ArrayList<Integer>> A){

        int[][] memo = new int[A.size()][A.get(0).size()];
        boolean isRowPath = true;
        boolean isColPath = true;
        for(int i = 0; i < memo.length; i++){
            for(int j =0; j < memo[0].length; j++){
                if(i==0 && j==0 ){
                   if(A.get(i).get(j) == 0)
                       memo[i][j] = 0;
                   else return 0;
                }
                else if(i==0) {
                    if (A.get(i).get(j)== 0 && isRowPath)
                    memo[i][j] = 1;
                    else isRowPath = false;
                }
                else if(j==0) {
                    if (A.get(i).get(j)== 0 && isColPath)
                        memo[i][j] =  1;
                    else isColPath = false;
                }

                else if (A.get(i).get(j) == 0){
                    int case1 = 0,case2 = 0;
                    if(memo[i][j-1] > 0)
                    case1 = memo[i][j-1];
                    if(memo[i-1][j] > 0)
                    case2 = memo[i-1][j];
                    memo[i][j] = case1+case2;
                }

            }
        }
        LongestCommonSubsequence.printTable(memo);

      return memo[A.size()-1][A.get(0).size()-1];
    }


}

