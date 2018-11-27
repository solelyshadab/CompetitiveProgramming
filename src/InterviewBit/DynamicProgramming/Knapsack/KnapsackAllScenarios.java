package InterviewBit.DynamicProgramming.Knapsack;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackAllScenarios {
    public static void main(String [] args){
        KnapsackAllScenarios a = new KnapsackAllScenarios();


        ArrayList<Integer> weight = new ArrayList<>(Arrays.asList(1,3,4,5));
        ArrayList<Integer> value = new ArrayList<>(Arrays.asList(100,10,10,70));
        //System.out.println("MaxValue Bounded " + a.maxValueBounded(4, weight,value));
        //System.out.println("MaxValue Unbounded " + a.maxValueUnbounded(4, weight,value));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,6));
        ArrayList<Integer> weight1 = new ArrayList<>(Arrays.asList(1,3));
        ArrayList<Integer> value1 = new ArrayList<>(Arrays.asList(5,3));
        System.out.println(a.minValueUnbounded(6,weight1,value1));

    }

    /****Below Solutions are for Min Values, as asked in InterviewBit problem****/

    public int minValueUnbounded(int W, ArrayList<Integer> weight, ArrayList<Integer> value){

        int[] memo = new int[W+1];
        memo[0] = 0;
        for(int i =1; i < memo.length;i++)
            memo[i] = Integer.MAX_VALUE;

        for(int i =0 ; i <= W ; i++ ){
            for(int j = 1 ; j <= weight.size(); j++){
                if(i - weight.get(j-1) >=0){
                    memo[i] = Math.min(memo[i], memo[i-weight.get(j-1)] + value.get(j-1));
                }
            }
        }

        return memo[W];
    }



    /***Below solutions are for Max Values ***/

    // Unbounded, max value, uses O(W) space only..preferred solution
    public int maxValueUnbounded(int W, ArrayList<Integer> weight, ArrayList<Integer> value){

        int[] memo = new int[W+1];

        for(int i =0 ; i <= W ; i++ ){
            for(int j = 1 ; j <= weight.size(); j++){
                if(i - weight.get(j-1) >=0){
                    memo[i] = Math.max(memo[i], memo[i-weight.get(j-1)] + value.get(j-1));
                }
            }
        }

        return memo[W];
    }
    // Unbounded, uses O(W * N) extra space, just one change to Bounded in line 43(memo[i] instead of memo[i-1])
    public int maxValueUnbounded1(int W, ArrayList<Integer> weight, ArrayList<Integer> value){
        int N = weight.size();
        int[][] memo = new int[N+1][W+1];

        for(int i =1 ; i <= N ; i++ ){
            for(int j = 0; j <=W; j++){
                if(j- weight.get(i-1) >=0){
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-weight.get(i-1)] + value.get(i-1));
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        return memo[N][W];
    }

// Typical knapsack problem solution, max value bounded, uses O(W * N) space..
    public int maxValueBounded(int W, ArrayList<Integer> weight, ArrayList<Integer> value){
        int N = weight.size();
        int[][] memo = new int[N+1][W+1];

        for(int i =1 ; i <= N ; i++ ){
            for(int j = 0; j <=W; j++){
                if(j- weight.get(i-1) >=0){
                    memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-weight.get(i-1)] + value.get(i-1));
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        return memo[N][W];
    }
}
