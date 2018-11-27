package InterviewBit.Backtracking;

import java.util.ArrayList;

public class PermutationsofIntegers {
    public static void main(String[] args){
        PermutationsofIntegers a = new PermutationsofIntegers();
        ArrayList<Integer> A = new ArrayList<>();
        //A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
        //A.add(6);A.add(7);A.add(8);A.add(9);A.add(10);
        A.add(5);A.add(6);A.add(4);A.add(2);
        a.solution(A);
        System.out.println();

    }
    public ArrayList<ArrayList<Integer>> solution(ArrayList<Integer> A){
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
       ansList = permutations(A, A.size(), ansList);
        return permutations(A, A.size(), ansList);
    }

    private static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> A, int size, ArrayList<ArrayList<Integer>> ansList ){
        if(size ==1){
            ArrayList<Integer> B = new ArrayList<>();
            for(int i =0; i < A.size(); i++){
                B.add(A.get(i));
            }
            ansList.add(B);
            return ansList;
        }
        for(int i =0; i < size ; i++){
            permutations(A, size-1, ansList);

            if(size % 2 == 1){
                int temp = A.get(0);
                A.set(0, A.get(size-1));
                A.set(size-1,temp);
            }
            else{
                int temp =  A.get(i);
                A.set(i, A.get(size-1) );
                A.set(size-1, temp);
            }

        }


        return ansList;
    }
}
