package InterviewBit.DynamicProgramming.TwoDStringDP;

public class RepeatingSubsequence {
    public static void main(String[] args){
        RepeatingSubsequence a = new RepeatingSubsequence();
        System.out.println(a.solution("abab"));
    }

    public int solution(String A){
        int n = A.length();
        int[][] memo = new int[n+1][n+1];

        for(int i =0; i <=n;i++){
            for(int j =0; j <=n;j++){
                if(i==0 || j ==0)
                    memo[i][j] =0;

                else if(i!=j &&A.charAt(i-1) == A.charAt(j-1))
                memo[i][j] = 1 + memo[i-1][j-1];

                else {
                    int case1 = memo[i-1][j];
                    int case2 = memo[i][j-1];

                    memo[i][j] = Math.max(case1,case2);

                }

            }
        }

return memo[n][n];
    }
}
