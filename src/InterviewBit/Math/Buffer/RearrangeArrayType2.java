package InterviewBit.Math.Buffer;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayType2 {
    public static void main(String[] args){
        RearrangeArrayType2 a = new RearrangeArrayType2();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(3);A.add(0);A.add(2);
        //1        3          0         2
        //2        0          3         1
        //1 + 2*4  3 + 0*4    0 + 3*4   2 + 1*4
        //oldvalue + newvalue * size
        A.add(2);A.add(0);A.add(1);A.add(4);A.add(5);A.add(3);
        System.out.println(Arrays.toString(a.rearrange(A).toArray()));
    }

    public ArrayList<Integer> rearrange(ArrayList<Integer> A){
        for(int i = 0; i < A.size(); i++){
            int index = A.get(i) % A.size();
            int oldValue = A.get(index);
            int updatedValue = oldValue + i * A.size();
            A.set(index, updatedValue);
        }

        for(int i = 0; i < A.size(); i++){
            int newValue = A.get(i) / A.size();
            A.set(i, newValue);
        }


        return A;
    }
}
