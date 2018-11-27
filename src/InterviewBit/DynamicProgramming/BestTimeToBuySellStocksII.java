package InterviewBit.DynamicProgramming;

import java.util.*;

public class BestTimeToBuySellStocksII {

    public int maxProfit(final List<Integer> A) {
        if(A==null || A.size() <=1)
            return 0;

        int profit = 0;
        for(int i = 0; i < A.size()-1; i++){
            if(A.get(i+1) - A.get(i) > 0)
                profit += A.get(i+1) - A.get(i);
        }

        return profit;
    }
}
