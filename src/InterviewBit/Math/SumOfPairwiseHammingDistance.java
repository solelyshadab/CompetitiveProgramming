package InterviewBit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfPairwiseHammingDistance {
    public static void main(String[] args){
        SumOfPairwiseHammingDistance a = new SumOfPairwiseHammingDistance();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,7));
        System.out.println(a.solve(A));
    }

    public int solve(ArrayList<Integer> A) {
        long ans = 0;
        long count = 0;
        int n = A.size();

        for (int i = 0; i < 31; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if ((A.get(j) & (1 << i)) == 0)
                    count++;
            }
            ans=(ans+count*(n-count)*2)%1000000007;
        }
        return (int) (ans);
    }
}
