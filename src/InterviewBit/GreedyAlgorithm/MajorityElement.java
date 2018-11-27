package InterviewBit.GreedyAlgorithm;
import java.util.*;

// Solution1: O(n) running time, constant space O(1)
public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int major_index = 0;
        int count = 1;

        for(int i =1; i < A.size();i++){
            if(A.get(i).equals(A.get(major_index))){
                count++;
            }else{
                count--;
            }

            if(count==0){
                major_index = i;
                count =1;
            }
        }

        return A.get(major_index);
    }

    // Solution 2: Usinng Hashing,  O(n) running time, but uses O(n) space.
    public int majorityElement1(final List<Integer> A) {
        if(A.size()==1)
            return A.get(0);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < A.size() ; i++){
            int value = A.get(i);

            if(map.containsKey(value)){
                int count = map.get(value) +1;

                if(count > (A.size()/2))
                    return value;
                else
                    map.put(value, count);

            }else{
                map.put(value, 1);
            }

        }

        return -1;

    }
}
