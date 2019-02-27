package InterviewBit.BitManipulation;

import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int ans = A.get(0);
        for(int i =1; i < A.size(); i++){
            ans = ans ^ A.get(i);
        }

        return ans;
    }
}
