package InterviewBit.Arrays;

import java.util.*;

public class WaveArray {
    public static void main(String[] args){
        WaveArray a = new WaveArray();

        ArrayList<Integer> A = new ArrayList<>();
//        A.add(5);A.add(1);A.add(3);
//        A.add(2);A.add(4);
//        A.add(5);A.add(23);
        A.add(1);A.add(2);
        System.out.println(Arrays.toString(a.Array(A).toArray()));
    }

    public ArrayList<Integer> Array(ArrayList<Integer> A){
        //Solution1(O(nLogn)):  Had to use this because of below condition:
        // If multiple answer possible, return the one that's lexicographically correct.
        Collections.sort(A);
        for (int i=0; i<A.size()-1; i += 2) {
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
        }

// Solution 2: O(N) running time
//        for(int i = 0; i< A.size(); i +=2){
//            if(i != A.size()-1 && A.get(i) < A.get(i+1) ){
//                int temp = A.get(i);
//                A.set(i, A.get(i+1));
//                A.set(i+1, temp);
//            }
//
//            if(i != 0 &&  A.get(i) < A.get(i-1)){
//                int temp = A.get(i);
//                A.set(i, A.get(i-1));
//                A.set(i-1, temp);
//            }
//
//        }

        return A;
    }

}
