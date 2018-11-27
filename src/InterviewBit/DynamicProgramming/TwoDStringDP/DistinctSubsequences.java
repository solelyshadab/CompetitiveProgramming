package InterviewBit.DynamicProgramming.TwoDStringDP;

public class DistinctSubsequences {
    public static void main(String[] args){
        DistinctSubsequences a = new DistinctSubsequences();
        System.out.println(a.count("aadbbcbcac", "aabcc"));
    }

    public int count(String A, String B){

        int n = A.length();
        int m = B.length();

        int[][] memo = new int[m+1][n+1];

        for(int i = 0; i <= m ; i++){
            for(int j =0; j <= n ; j++){
                if(i==0)
                    memo[i][j] = 1;
                else if(j==0)
                    memo[i][j] = 0;
                else if(B.charAt(i-1) == A.charAt(j-1)){
                    int case1 = memo[i-1][j-1];
                    int case2 = memo[i][j-1];
                    memo[i][j] = case1 + case2;
                }

                else {
                   memo[i][j] = memo[i][j-1];
                }

            }
        }
        printTable(memo);
        return memo[m][n];
    }


    private static void printTable(int[][] table){
        for(int[] row : table){
            for(int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
