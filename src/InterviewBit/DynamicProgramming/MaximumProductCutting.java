package InterviewBit.DynamicProgramming;

/**
 * Created by 609112524 on 04/04/2019.
 */
public class MaximumProductCutting {
    public static void main(String[] args){
        for(int i = 2; i < 11 ; i++)
            System.out.println(maxProduct(i));
    }
    //1 2 4 6 9 12 18 27 36
    private static int maxProduct(int n){
        int[] memo = new int[n+1];

        for(int i = 1; i <= n ; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1; j < i; j++){
                max = Math.max(max, Math.max(j * (i-j), j * memo[i-j] ));
            }
            memo[i] = max;
        }
        return memo[n];
    }

    private static int cutRod(int[] prices, int n){
        int[] memo = new int[n+1];

        for(int i = 1; i <= n ; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0 ; j < i; j++){
                max = Math.max(max, memo[i-j-1] + prices[j]);
            }
            memo[i] = max;
        }
        return memo[n];
    }
}
