package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class DifferentBitsSumPairwise {
    public int cntBits(ArrayList<Integer> A) {
        long ans = 0; int n = A.size();

        for(int i =0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < A.size(); j++){
                if( (A.get(j) & (1 << i)) == 0)
                    count ++;
            }
            ans = ( ans + 2 * count * (n- count) ) % 1000000007;
        }

        return (int) ans % 1000000007;
    }



}
