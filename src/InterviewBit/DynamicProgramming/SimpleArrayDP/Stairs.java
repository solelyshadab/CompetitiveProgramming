package InterviewBit.DynamicProgramming.SimpleArrayDP;

public class Stairs {

    public int climbStairs(int A) {
        int[] memo = new int[A+1];
        memo[0] = 1;
        memo[1] = 1;

        for(int i =2; i < memo.length ; i++ ){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[memo.length-1];
    }
}
