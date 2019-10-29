package InterviewBit.DynamicProgramming;

/**
 * Created by 609112524 on 01/04/2019.
 */
public class PartitionProblem {
    public static void main(String... args){
        int arr[] = {3, 1, 1, 2, 2,1};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into twosubsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");

    }
    private static boolean findPartition(int[] arr, int n){

        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum+= arr[i];

        if(sum % 2 !=0)
            return false;

        boolean[][] memo = new boolean[sum/2 +1][n+1];

        for(int j = 0; j < memo[0].length; j++)
            memo[0][j] = true;

        for(int i = 1; i < memo.length; i++){
            for(int j = 1; j < memo[0].length; j++){
                memo[i][j] = memo[i][j-1];

                if(arr[j-1] <= i){
                    memo[i][j] = memo[i][j] || memo[i - arr[j-1]][j-1];
                }
            }
        }
        for (int i = 0; i <= sum/2; i++)
        {
            for (int j = 0; j <= n; j++)
                System.out.print ( "\t" + memo[i][j]);
            System.out.println("\n");
        }

        return memo[sum/2 -1][n];
    }

}
