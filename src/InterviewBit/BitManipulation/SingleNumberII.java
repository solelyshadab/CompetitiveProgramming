package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumberII {
    public static void main(String[] args){
        SingleNumberII a = new SingleNumberII();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,3,2,3,2,2));
        System.out.println(a.getSingle(A));
    }

    public int getSingle(ArrayList<Integer> A){
        int ones = 0; int twos = 0;
        int common_bit_mask;

        for(int i =0; i < A.size(); i++){

            twos = twos | (ones & A.get(i));
            ones = ones ^ A.get(i);
            common_bit_mask = ~(ones & twos);

            ones &= common_bit_mask;

            twos &= common_bit_mask;
        }
        return ones;
    }
}
