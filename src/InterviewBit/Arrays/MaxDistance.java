package InterviewBit.Arrays;
import java.util.*;

public class MaxDistance {
    public static void main(String[] args){
        MaxDistance a = new MaxDistance();
        List<Integer> A = new ArrayList<>(Arrays.asList(1,10));
        System.out.println(a.maximumGap(A));
    }

    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        int[] LMin = new int[n];
        int[] RMax = new int[n];

        LMin[0] = A.get(0);
        for(int i =1; i < n ; i++){
            LMin[i] = Math.min(A.get(i), LMin[i-1]);
        }
        RMax[n-1] = A.get(n-1);
        for(int i = n-2 ; i>=0; i-- ){
            RMax[i] = Math.max(A.get(i), RMax[i+1]);
        }

        int i =0; int j = 0; int maxDiff = -1;
        while(i < n && j < n){
            if(LMin[i] <= RMax[j]){
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }
            else{
                i++;
            }
        }

        return maxDiff;

    }
}
