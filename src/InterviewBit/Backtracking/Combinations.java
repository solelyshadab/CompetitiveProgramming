package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
    public static void main(String[] args){
        Combinations a = new Combinations();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(3);A.add(4);
        //A.add(1);A.add(2);A.add(1);
        ArrayList<ArrayList<Integer>> ansList = a.combine(5,2);

        for(ArrayList<Integer> list : ansList)
            System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        if(B>A)
            return ansList;
        ArrayList<Integer> x = new ArrayList<>();
        for(int i =1; i <=A; i++){
            x.add(i);
        }
        //ansList = solution(x, ansList, new int[B], 0, x.size()-1, 0, B);
        ansList = solution1(x,ansList,new ArrayList<>(),0,B);
        return ansList;
    }
    //Solution2: My solution, accepted and much simpler..
    private static ArrayList<ArrayList<Integer>> solution1(ArrayList<Integer> A,
                                                           ArrayList<ArrayList<Integer>> ansList,
                                                           ArrayList<Integer> ans, int start, int k){
        if(ans.size()==k){
            ansList.add(new ArrayList<>(ans));
            return ansList;
        }

        for(int i = start; i < A.size(); i++){
            ans.add(A.get(i));
            solution1(A,ansList, ans,i+1, k);
            ans.remove(ans.size()-1);
        }


        return ansList;

    }

    // Solution1: Accepted by interviewbit..
    private static ArrayList<ArrayList<Integer>> solution(ArrayList<Integer> A,
                                                          ArrayList<ArrayList<Integer>> ansList,
                                                          int[] B, int start, int end,int index, int k ){
        if(index == k){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i =0; i < B.length; i++){
                ans.add(B[i]);
            }
            ansList.add(ans);
            return ansList;
        }

        for(int i = start; i <=end && end - i +1 >= k - index; i++){
            B[index] = A.get(i);
            solution(A, ansList,B, i+1, end, index+1, k);
        }

        return ansList;

    }




}
