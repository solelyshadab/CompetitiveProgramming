package InterviewBit.DynamicProgramming.TwoDStringDP;

import java.util.*;

public class LongestIncreasingSubsequence {

    public int lis(final List<Integer> A) {
        int[] lis = new int[A.size()];

        Arrays.fill(lis, 1);

        for(int i = 0; i < A.size(); i++){
            for(int j =0; j < i; j++){
                if(A.get(i) > A.get(j) && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] + 1 ;
            }
        }

        int max = 0;

        for(int i = 0; i < lis.length; i++){
            if(lis[i] > max)
                max = lis[i];
        }

        return max;


    }
}
