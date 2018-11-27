package InterviewBit.TwoPointers;

import java.lang.reflect.Array;
import java.util.*;

public class MergeTwoSortedListsII {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(1);A.add(5);A.add(8);
        B.add(6);B.add(9);
        MergeTwoSortedListsII a = new MergeTwoSortedListsII();
        System.out.println(Arrays.toString(a.mergeLists(A,B).toArray()));

    }

    public List<Integer> mergeLists(ArrayList<Integer> a, ArrayList<Integer> b){

        int i = 0;
        int j =0;
        while(i < a.size() && j < b.size()){
           if(b.get(j) < a.get(i)){
               a.add(i, b.get(j));
               j++;
               i++;
           }else {
               i++;
           }
       }

       if(j < b.size()){
            for(int x = j; x < b.size(); x++){
                a.add(b.get(x));
            }
       }


        return a;
    }

}
