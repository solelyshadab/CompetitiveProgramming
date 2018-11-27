package InterviewBit.DynamicProgramming.MultiplyDP;

public class UniqueBinarySearchTreeII {
    public int numTrees(int A) {
        if(A <0)
            return 0;

        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int n = 2; n <= A; n++) {
            for (int root = 1; root <= n; root++) {
                dp[n] += dp[root - 1] * dp[n - root];
            }
        }
        return dp[A];


    }
}
