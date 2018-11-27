package InterviewBit.DynamicProgramming.SuffixPrefixDP;

import java.util.*;

public class MaxProductSubarray {
    public static void main(String[] args){
        MaxProductSubarray a = new MaxProductSubarray();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 0, -4, 0, -2));
        System.out.println(a.maxProduct(A));
    }

    public int maxProduct(ArrayList<Integer> A){
        if(A==null || A.size()==0)
            return 0;

        int minVal, maxVal, maxProduct;
        minVal = maxVal = maxProduct = A.get(0);

        for(int i = 1; i < A.size(); i++){
            int value = A.get(i);

            if(value < 0){
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            maxVal = Math.max(value, maxVal * value);
            minVal = Math.min(value, minVal * value);

            maxProduct = Math.max(maxProduct, maxVal);

        }

        return maxProduct;
    }
}
