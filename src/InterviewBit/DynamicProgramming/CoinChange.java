package InterviewBit.DynamicProgramming;

/**
 * Created by 609112524 on 17/04/2019.
 */
public class CoinChange {
    public static void main(String[] args){
        int[] arr = {1,3,5,7};
        System.out.println(minUsingDP(arr,15));
    }

    // By recursion
    public static int min(int[] arr, int n){
        if(n == 0)
            return 0;

        if(n < 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            int res = min(arr, n - arr[i]);

            if(res != Integer.MAX_VALUE)
            min = Math.min(min, res+1);
        }

        return min;
    }

    public static int minUsingDP(int[] arr, int n){
        int[] memo = new int[n+1];

        for(int i = 1; i < memo.length; i++){
            memo[i] = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < arr.length; j++){

                if(i - arr[j] >=0)
                    min = memo[i - arr[j]];

                if(min != Integer.MAX_VALUE)
                    memo[i] = Math.min(memo[i], min + 1);

            }

        }

        return memo[n];
    }

}
