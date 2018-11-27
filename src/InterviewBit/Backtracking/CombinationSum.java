package InterviewBit.Backtracking;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args){
        CombinationSum a = new CombinationSum();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);A.add(4);A.add(6);A.add(8);
        ArrayList<ArrayList<Integer>> ansList = a.combinationSum(A,8);
        for(ArrayList<Integer> list : ansList)
            System.out.println(list);
    }


    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        A = removeDuplicates(A);
        return util(A,B, 0, new ArrayList<>(), new ArrayList<>());
    }

    private ArrayList<ArrayList<Integer>> util(ArrayList<Integer> A,int sum, int start,
                                               ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> ans){
        if(sum <=0){
            if(sum==0){
                ArrayList<Integer> temp = new ArrayList<>(ans);
                ansList.add(temp);
            }
            return ansList;
        }

        for(int i = start; i < A.size() ; i++){
            ans.add(A.get(i));
            ansList = util(A,sum-A.get(i),i, ansList, ans );
            ans.remove(ans.size()-1);
        }

        return ansList;
    }

    private ArrayList<Integer> removeDuplicates(ArrayList<Integer> A){
        int index = 0;
        int i =0;
        for(; i < A.size()-1; i++){
            if(!A.get(i).equals(A.get(i+1))){
                A.set(index, A.get(i));
                index++;
            }
        }

        A.set(index, A.get(i));

        while(A.size() - index > 1)
            A.remove(A.size()-1);

        return A;
    }

}
