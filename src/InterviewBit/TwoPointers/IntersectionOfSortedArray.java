package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
//        A.add(0);A.add(1);A.add(3);A.add(5);A.add(7);A.add(9);A.add(12);A.add(13);
//        B.add(0);B.add(1);B.add(4);B.add(6);B.add(7);B.add(9);A.add(12);A.add(15);
        A.add(-254);A.add(-129);A.add(250);A.add(245678910);
        B.add(-254);B.add(-129);B.add(0);B.add(240);B.add(350);B.add(245678910);
        IntersectionOfSortedArray a = new IntersectionOfSortedArray();
        System.out.println(Arrays.toString(a.intersection(A, B).toArray()));
    }

    public ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> ansList = new ArrayList<>();
        int i =0;
        int j =0;

        while (i < a.size() && j < b.size()){
            if(a.get(i).equals(b.get(j))){
                ansList.add(a.get(i));
                i++;
                j++;
                continue;
            }

            if(a.get(i) < b.get(j)){
                i++;
            }

            else if(b.get(j) < a.get(i))
                j++;


        }

     return ansList;
    }


}
