package InterviewBit.DynamicProgramming;

/**
 * Created by 609112524 on 30/04/2019.
 */
public class DiceThrow {
    public static void main(String[] args){
        System.out.println(findWays(4, 2, 1));
        System.out.println(findWays(2, 2, 3));
        System.out.println(findWays(6, 3, 8));
        System.out.println(findWays(4, 2, 5));
        System.out.println(findWays(4, 3, 5));

    }

    public static long findWays(int m, int n, int X){
        long[][] memo = new long[n+1][X+1];

        for(int i = 1; i <= X; i++){
            memo[1][i] = 1;
        }

        for(int i = 2; i <=n; i++){
            for( int j = 1; j <= X; j++){
                for(int k = 1; k <=m && k < j ; k++){
                    memo[i][j] += memo[i-1][j-k];
                }

            }
        }

        return memo[n][X];
    }
}
