package InterviewBit.Arrays;

import java.util.*;

public class FindDuplicateInArray {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(3);
        A.add(1);A.add(6);A.add(3);A.add(6);

        FindDuplicateInArray a = new FindDuplicateInArray();
        System.out.println(a.repeatedNumber(A));
    }
    // Solution 1: Uses only constant space
    public int findDuplicate(final List<Integer> a){

        int slow = a.get(0);
        int fast = a.get(a.get(0));
        while (slow != fast) {
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        }

        fast = 0;
        while (slow != fast) {
            slow = a.get(slow);
            fast = a.get(fast);
        }
        if(slow==0) return -1;
        return slow;
    }
    // Uses extra space, but answer got accepted in InterviewBit
    public int repeatedNumber(final List<Integer> a) {
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;
        for(int i =0; i < a.size(); i++){
            if(set.contains(a.get(i)))
                return a.get(i);
            else
                set.add(a.get(i));
        }

        return ans;
    }
}
