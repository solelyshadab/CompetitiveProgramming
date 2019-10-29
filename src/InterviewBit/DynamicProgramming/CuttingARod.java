package InterviewBit.DynamicProgramming;

/**
 * Created by 609112524 on 02/04/2019.
 */
public class CuttingARod {
    public static void main(String[] args){
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));

    }
    // 1 2 3 4 5  6  7  8
    // 1 5 8 9 10 17 17 20
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
