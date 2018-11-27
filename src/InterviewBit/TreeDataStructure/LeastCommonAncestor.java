package InterviewBit.TreeDataStructure;

import java.util.*;

public class LeastCommonAncestor {

    ArrayList<Integer> path1;
    ArrayList<Integer> path2;
    public LeastCommonAncestor(){
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
    }
    public static void main(String[] args){
        LeastCommonAncestor a = new LeastCommonAncestor();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.right.left = a.new TreeNode(6);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        System.out.println("Key may not be present - lca is: " + a.lca(root,2,5));
        System.out.println("Key is def. present - lca is: " + a.lca1(root,2,5).val);
    }
    // Solution: Takes O(n) extra space, but works even if key is not present
    public int lca(TreeNode A, int B, int C) {

        path1.clear();
        path2.clear();

        if (!path(A, B, path1) || !path(A, C, path2))
            return -1;

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);

    }
    private static boolean path(TreeNode a, int b, ArrayList<Integer> ansList){
        if(a==null)
            return false;

        ansList.add(a.val);

        if(a.val == b)
            return true;

        if(a.left !=null && path(a.left,b, ansList))
            return true;
        if(a.right !=null && path(a.right,b, ansList))
            return true;
        ansList.remove(ansList.size()-1);

        return false;
    }

    //Solution 2: Takes constant space, but works only if we know key is present
    public TreeNode lca1(TreeNode A, int B, int C){
        if(A==null)
            return null;

        if(A.val == B || A.val == C)
            return A;

        TreeNode leftNode = lca1(A.left, B,C);
        TreeNode rightNode = lca1(A.right,B,C);

        if(leftNode !=null && rightNode !=null)
            return A;

        if(leftNode !=null) return leftNode;
        else return rightNode;

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
