package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray a = new RemoveDuplicatesFromSortedArray();
        ArrayList<Integer> A = new ArrayList<>();
        //A.add(0);A.add(1); A.add(2);A.add(2);A.add(5);A.add(5);A.add(5);
        A.add(6);A.add(6);A.add(6);
        System.out.println(a.solution(A));
    }
// 0 0 1 1 1 2 2
    public int solution(ArrayList<Integer> a){
        if(a.size() <=1)
            return a.size();
        int index =0;
        for(int i =0; i < a.size()-1; i++){

            if(!a.get(i).equals(a.get(i+1)) ){
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                index++;
            }

            if(i == a.size()-2){
                int temp = a.get(i+1);
                a.set(i+1, a.get(index));
                a.set(index, temp);
                index++;
            }


        }

        return index;
    }
}
