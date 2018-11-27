package InterviewBit.Math;

import java.util.*;

public class RearrangeArray {
    public static void main(String[] args){
        RearrangeArray a = new RearrangeArray();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);A.add(2);A.add(0);A.add(1);
        //3       2       0        1
        //1       0       3        2
        //3+1*4   2+0*4   0+3*4    1+2*4
        //oldValue+ newValue*N
        System.out.println(Arrays.toString(a.rearrange(A).toArray()));
    }

    public ArrayList<Integer> rearrange(ArrayList<Integer> A){

        for(int i = 0; i < A.size(); i++){
            int index = A.get(i);
            int newValueIntoN = A.get(index)%A.size() * A.size();
            int updatedValue = A.get(i)%A.size() + newValueIntoN;
            A.set(i, updatedValue);
//            int value = A.get(i);
//            // (arr[arr[i]]%n) * n
//            int increment = (A.get(value)%A.size()) * A.size();
//            A.set(i, value + increment);
        }

        for(int i = 0; i < A.size(); i++){
            int newValue = A.get(i) / A.size();
            A.set(i, newValue);
        }


        return A;
    }
}
