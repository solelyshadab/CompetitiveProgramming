package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {
    public static void main(String[] args) {
        RootToLeafPathsWithSum a = new RootToLeafPathsWithSum();
        TreeNode root = a.new TreeNode(5);
        root.left = a.new TreeNode(4);
        root.right = a.new TreeNode(8);
        root.left.left = a.new TreeNode(11);
        root.left.left.left = a.new TreeNode(7);
        root.left.left.right = a.new TreeNode(2);
        root.right.left = a.new TreeNode(13);
        root.right.right = a.new TreeNode(4);
        root.right.right.left = a.new TreeNode(5);
        root.right.right.right = a.new TreeNode(1);
        for (ArrayList<Integer> list : a.solutionUtil(root, 22))
            System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> solutionUtil(TreeNode A, int sum) {
        return solution(A, sum, new ArrayList<>(), new ArrayList<>());
    }

    private static ArrayList<ArrayList<Integer>> solution(TreeNode A, int sum,
                                                          ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> list) {
        if (A == null) {
            return ansList;
        }

        sum -= A.val;
        list.add(A.val);
        if (sum == 0 && A.right == null && A.left == null) {
            ansList.add(new ArrayList<>(list));
        }
        solution(A.left, sum, ansList, new ArrayList<>(list));
        solution(A.right, sum, ansList, new ArrayList<>(list));

        return ansList;

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
}
