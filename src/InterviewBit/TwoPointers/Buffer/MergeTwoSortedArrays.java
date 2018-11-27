package InterviewBit.TwoPointers.Buffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(0);A.add(1);A.add(3);A.add(5);A.add(7);
        B.add(1);B.add(1);B.add(4);B.add(6);
        MergeTwoSortedArrays a = new MergeTwoSortedArrays();
        System.out.println(Arrays.toString(a.mergeLists(A, B).toArray()));
    }

    public ArrayList<Integer> mergeLists(List<Integer> A, List<Integer> B){
       ArrayList<Integer> ansList = new ArrayList<>();
       int i = 0;
       int j =0;

       while(i < A.size() && j < B.size()){
           if(A.get(i) < B.get(j)){
               ansList.add(A.get(i));
               i++;
           }else {
               ansList.add(B.get(j));
               j++;
           }
       }

       if(i < A.size()){
           for(int a = i; a < A.size(); a++){
               ansList.add(A.get(a));
           }
       }

       if(j < B.size()){
           for(int a = j; a < B.size(); a++){
               ansList.add(B.get(a));
           }
       }

        return ansList;
    }
}
