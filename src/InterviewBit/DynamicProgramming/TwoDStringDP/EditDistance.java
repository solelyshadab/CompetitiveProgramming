package InterviewBit.DynamicProgramming.TwoDStringDP;

public class EditDistance {
    public static void main(String[] args){
        EditDistance a = new EditDistance();
    }

    public int solution(String A, String B){
        A = A.trim();
        B = B.trim();
        int n = A.length();
        int m = B.length();
        int[][] memo = new int[n+1][m+1];

        for(int i =0; i <=n; i++){
            for(int j = 0; j <=m ; j++){

                if(i==0)
                    memo[i][j] = j;

                else if(j==0)
                    memo[i][j] = i;

                else if(A.charAt(i-1) == B.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1];

                else{
                    int case1 = 1 + memo[i-1][j]; // Delete
                    int case2 = 1 + memo[i][j-1]; // Insert
                    int case3 = 1 + memo[i-1][j-1]; // Replace

                    memo[i][j] = Math.min(Math.min(case1, case2), case3);

                }

            }
        }

        return memo[n][m];



    }



}
