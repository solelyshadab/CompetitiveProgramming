package InterviewBit.DynamicProgramming.SuffixPrefixDP;

import java.util.ArrayList;
import java.util.Arrays;

public class BestTimeToBuySellStocksI {
    public static void main(String[] args){
        BestTimeToBuySellStocksI a = new BestTimeToBuySellStocksI();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1));
        System.out.println(a.bestTime(A));
    }

    public int bestTime(ArrayList<Integer> A){
        if(A==null || A.size() <=1)
            return 0;

        int profit = Integer.MIN_VALUE;
        int min = A.get(0);

        for(int i =1; i < A.size(); i++){
            // if(A.get(i) < min)
            // min = A.get(i);
            min = Math.min(min, A.get(i));

            // if(profit < A.get(i) - min)
            // profit = A.get(i) - min;
            profit = Math.max(profit, (A.get(i) - min) );

        }

        return profit;

    }
}
