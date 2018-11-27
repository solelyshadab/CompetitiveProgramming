package InterviewBit.Hashing;
import java.util.*;

public class DiffKII {
    public static void main(String[] args){
        DiffKII a = new DiffKII();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(a.diffPossible(A,1));
    }

    public int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < A.size(); i++){
            map.put(A.get(i), i);
        }

        for(int i = 0; i < A.size(); i++){
            int value = A.get(i) + B;
            if(map.containsKey(value) && i != map.get(value)){
                return 1;
            }
        }

        return 0;
    }
}
