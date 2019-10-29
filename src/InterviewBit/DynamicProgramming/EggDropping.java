package InterviewBit.DynamicProgramming;

/**
 * Created by 609112524 on 30/04/2019.
 */
public class EggDropping {
    public static void main(String[] args){
        System.out.println(eggDrop(2,10));
        System.out.println(eggDrop1(2,10));
    }
    //Using recursion, n = eggs, k = floors
    public static int eggDrop(int n, int k){

        if(k==0 || k ==1)
            return k;

        if(n==1)
            return k;


        int min = Integer.MAX_VALUE;
        int res;

        for(int x = 1; x <= k; x++){
            res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x));

            if(res < min)
                min = res;
        }
        return min +1;
    }

    //Using DP
    public static int eggDrop1(int n, int k){

        int[][] memo = new int[n+1][k+1];

        // We need one trial for one floor and 0 trials for 0 floors
        for(int i = 1; i<=n; i++){
            memo[i][1] = 1;
            memo[i][0] = 0;
        }
        // We need j trials for 1 egg and j floors
        for(int j = 1; j <= k ; j++){
            memo[1][j] = j;
        }

        int res;
        for(int i = 2; i <= n ; i++){
            for(int j = 2; j <=k ; j++){

                memo[i][j] = Integer.MAX_VALUE;
                for(int x= 1 ; x <= j; x++){
                    res = 1 + Math.max( memo[i-1][x-1], memo[i][j-x]);

                    if(res < memo[i][j])
                        memo[i][j] = res;

                }

            }
        }

        return memo[n][k];
    }
}
