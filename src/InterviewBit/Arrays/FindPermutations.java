package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPermutations {
    public static void main(String[] args){

    }

    public ArrayList<Integer> findPermutation(final String A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = B;
        int min = 1;

        for (char c : A.toCharArray()) {
            if (c == 'D') {
                ans.add(max);
                max--;
            }
            else {
                ans.add(min);
                min++;
            }
        }

        ans.add(min);

        return ans;
    }
}
