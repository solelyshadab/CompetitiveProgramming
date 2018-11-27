package InterviewBit.TwoPointers;
import java.util.*;

public class ArrayThreePointers {
    public static void main(){
        ArrayThreePointers a = new ArrayThreePointers();

    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0; int j = 0; int k = 0;
        int diff = Integer.MAX_VALUE;

        while(i < A.size() && j < B.size() && k < C.size()){

            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            diff = Math.min(diff, (max-min));

            if(diff==0)
                return 0;

            if(A.get(i).equals(min))
                i++;
            else if(B.get(j).equals(min))
                j++;
            else
                k++;
        }

        return diff;
    }
}
