package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORValue {
    public int findMinXor(ArrayList<Integer> A) {
        long value = 0;
        long minXOR = Long.MAX_VALUE;
        Collections.sort(A);
        for(int i =0; i < A.size()-1; i++){
            value = A.get(i) ^ A.get(i+1);

            if(value < minXOR){
                minXOR = value;
            }
        }

        return (int) minXOR;
    }


    public int numSetBits(long a) {
        int count =0;
        while(a>0){
            count += a & 1;
            a >>= 1;
        }

        return count;
    }

}
