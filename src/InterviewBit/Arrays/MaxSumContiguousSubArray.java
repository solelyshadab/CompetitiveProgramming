package InterviewBit.Arrays;

import java.util.*;

public class MaxSumContiguousSubArray {

    public static void main(String[] args){
        int[] arr = {-2,-4,-1};
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }

        MaxSumContiguousSubArray a = new MaxSumContiguousSubArray();
        System.out.println(a.maxSubArray(list));
    }

    public int maxSubArray(final List<Integer> A) {

        int size = A.size();
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + A.get(i);
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;

//        int sum = Integer.MIN_VALUE;
//        int n = A.size();
//        for(int k = 1; k <= n; k++){
//            for(int i = 0 ; i <= n - k; i++){
//
//                int sumSubArray = 0;
//                for(int j = 0; j < k ; j++ ){
//                    sumSubArray += A.get(i+j);
//                }
//                if(sumSubArray > sum)
//                    sum = sumSubArray;
//            }
//        }
//
//        return sum;

    }

}
