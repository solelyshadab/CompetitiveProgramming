package InterviewBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args){
        MaxSumWithoutAdjacentElements a = new MaxSumWithoutAdjacentElements();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6,7,8,9,10));
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        C.add(A);C.add(B);
        System.out.println(a.maxSum(C));
    }

    public int maxSum(ArrayList<ArrayList<Integer>> A){
        if(A==null || A.size()==0)
            return 0;
        int memo[] = new int[A.get(0).size()+1];
        memo[0] = 0;
        memo[1] = Math.max(A.get(0).get(0), A.get(1).get(0));
        for(int i = 2; i < memo.length;i++){
            int value = Math.max(A.get(0).get(i-1), A.get(1).get(i-1));

            memo[i] = Math.max(memo[i-1], memo[i-2] + value);

        }

        return memo[memo.length-1];
    }
}
