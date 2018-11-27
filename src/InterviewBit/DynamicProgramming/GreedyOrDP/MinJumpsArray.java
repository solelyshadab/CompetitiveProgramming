package InterviewBit.DynamicProgramming.GreedyOrDP;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpsArray {
    public static void main(String[] args){
        MinJumpsArray a = new MinJumpsArray();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9));
        System.out.println(a.minJump(A));
    }

    public int minJump(ArrayList<Integer> A){
        if(A == null || A.size() == 0 || (A.get(0)==0 && A.size() > 1))
            return -1;

        if(A.get(0) == 0 && A.size()==1)
            return 0;

        int maxReach = A.get(0);
        int steps = A.get(0);
        int jump = 1;

        for(int i =1; i < A.size()-1; i++){
            //   if(i == A.size()-1)
            //       return jump;

            steps--;

            maxReach = Math.max(maxReach,A.get(i)+i);

            if(steps==0){
                jump++;

                // if(i >= maxReach)
                //     return -1;

                steps = maxReach - i;
                if(steps <0)
                    return -1;
            }

        }

        return jump;

    }



// Solution 2: Running time of O(n^2)
    public int jump(ArrayList<Integer> A) {
        if(A == null || A.size() == 0 || (A.get(0)==0 && A.size() > 1))
            return -1;

        int[] jumps = new int[A.size()];

        jumps[0] = 0;

        for(int i = 1; i < A.size() ; i++){
            jumps[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i ; j++){

                if(A.get(j) + j >= i && jumps[j] != Integer.MAX_VALUE ){
                    jumps[i] = Math.min(jumps[i], jumps[j]+1);
                    break;
                }
            }
        }
        if(jumps[A.size()-1] == Integer.MAX_VALUE)
            return -1;
        else
            return jumps[A.size()-1];


    }
}
