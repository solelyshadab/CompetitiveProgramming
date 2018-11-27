package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetWithAllPermutations {
    public static void main(String[] args) {
        SubsetWithAllPermutations a = new SubsetWithAllPermutations();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));

        a.subset(new ArrayList<Integer>(), A, new ArrayList<ArrayList<Integer>>());
        ArrayList<ArrayList<Integer>> ansList = a.subset(new ArrayList<Integer>(), A, new ArrayList<ArrayList<Integer>>());
    }
// This solution prints all permutations of the subset too, not applicable for Interview question
    public ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> first,
                                                ArrayList<Integer> second, ArrayList<ArrayList<Integer>> ansList) {

        System.out.println(first);
        for (int i = 0; i < second.size(); i++) {
            int ele = second.get(i);
            first.add(ele);
            second.remove(i);
            subset(first, second, ansList);
            second.add(i, ele);
            first.remove(first.size() - 1);
        }

        return ansList;
    }
}
