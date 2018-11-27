package InterviewBit.DynamicProgramming.Knapsack;

import java.util.*;

public class TusharsBirthdayParty {
    public static void main(String[] args) {
        TusharsBirthdayParty a = new TusharsBirthdayParty();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,6));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,3));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(5,3));
        System.out.println(a.solve1(A,B,C));

    }

    //My Solution, accepted by InterviewBit
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int ans = 0;
        for(int i =0; i < A.size();i++) {
            int W = A.get(i);
            ans += minValueUnbounded(W, B, C);
        }
        return ans;
    }


    private static int minValueUnbounded(int W, final List<Integer> weight, final List<Integer> value){

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


    // InterviewBit solution...
    public int solve1(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            max=Math.max(max,A.get(i));
        }

        int cost[]=new int[max+1];
        cost[0]=0;
        for(int i=1;i<max+1;i++){
            cost[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                for(int k=B.get(j);k<=A.get(i);k++){
                    cost[k]=Math.min(cost[k],C.get(j)+cost[k-B.get(j)]);
                }
            }
        }
        int ans=0;
        for(int i=0;i<A.size();i++){
            ans+=cost[A.get(i)];
        }
        return ans;

    }
}
