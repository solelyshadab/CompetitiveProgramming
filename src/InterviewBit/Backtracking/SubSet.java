package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubSet {
    public static void main(String[] args){
        SubSet subSet = new SubSet();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4,5,3,1,2));
        ArrayList<ArrayList<Integer>> result = subSet.subsets(a);

        for(ArrayList<Integer> list : result)
            System.out.println(list);
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        if (A.size() == 0)
            return output;
        Collections.sort(A);
        generate(A, output, new ArrayList<>(), 0);
        return output;
    }

    public void generate(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> ans, int index)
    {
        for (int i = index; i < A.size(); i++)
        {
            ans.add(A.get(i));
            ansList.add(new ArrayList<>(ans));
            generate(A, ansList, ans, i+1);
            ans.remove(ans.size() - 1);
        }
    }
}
