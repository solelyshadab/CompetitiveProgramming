package InterviewBit.Arrays.Buffer;
import java.util.*;

public class DuplicateInArray {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(3);
        A.add(1);A.add(6);A.add(3);A.add(6);

        DuplicateInArray a = new DuplicateInArray();
        System.out.println(Arrays.toString(a.findDuplicate(A).toArray()));
    }


    public ArrayList<Integer> findDuplicate(ArrayList<Integer> A){
        ArrayList<Integer> ansList = new ArrayList<>();

        int n = A.size();
        // First check all the values that are present in an array then go to that
        // values as indexes and increment by the size of array
        for (int i = 0; i < n; i++)
        {
            int index = A.get(i) % n;
            A.set(index, A.get(index)+n);
        }

        // Now check which value exists more
        // than once by dividing with the size of array
        for (int i = 0; i < n; i++)
        {
            if ((A.get(i)/n) > 1)
                ansList.add(i);
        }

return ansList;
    }
}
