package InterviewBit.DynamicProgramming.SimpleArrayDP;
import java.util.*;

public class LengthOfLongestSubsequence {

    public int longestSubsequenceLength(final List<Integer> A) {
        if(A == null || A.size()==0)
            return 0;
        int[] lis = new int[A.size()];
        int[] lds = new int[A.size()];

        Arrays.fill(lis,1);
        Arrays.fill(lds,1);

        for(int i = 1; i < lis.length; i++){
            for(int j = 0; j < i; j++){
                if(A.get(i) > A.get(j) && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] +1;
            }
        }

        for(int i = lds.length - 2; i >=0; i--){
            for(int j = lds.length -1; j > i ; j--){
                if(A.get(i) > A.get(j) && lds[j]+1 > lds[i])
                    lds[i] = lds[j] +1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i < lis.length; i++){
            if(max < lis[i] + lds[i] -1)
                max = lis[i] + lds[i] -1;
        }

        return max;
    }
}
