package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumConsecutiveGap {
    public static void main(String[] args){
        MaximumConsecutiveGap a = new MaximumConsecutiveGap();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(11,2,8,4,17));
        System.out.println(a.solve(A));
    }

    public int solve(ArrayList<Integer> A){
       int n = A.size();
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;

        for(int i =0; i < A.size(); i++){
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        int[] minBucket = new int[n-1];
        int[] maxBucket = new int[n-1];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        float gap = (float) ((max - min) / (n-1));

        for(int i = 0; i < n ; i++){
            if(A.get(i) == min || A.get(i) == max)
                continue;

            int index = (int)( (A.get(i) - min) / gap );

            maxBucket[index] = Math.max(maxBucket[index], A.get(i));

            minBucket[index] = Math.min(minBucket[index], A.get(i));
        }

        int prevVal = min; int maxDiff = 0;
        for(int i = 0; i < n-1; i++){
            if(minBucket[i] == Integer.MAX_VALUE)
                continue;

            maxDiff = Math.max(maxDiff, minBucket[i] - prevVal);
            prevVal = maxBucket[i];
        }

        maxDiff = Math.max(maxDiff, max - prevVal);

        return maxDiff;
    }

}
