package InterviewBit.TreeDataStructure;

import java.util.concurrent.atomic.AtomicLong;

public class SymmetricBinaryTree {
    public static void main(String[] args){
        SymmetricBinaryTree a = new SymmetricBinaryTree();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(2);
        root.left.left = a.new TreeNode(3);
        root.left.right = a.new TreeNode(4);
        root.right.left = a.new TreeNode(4);
        root.right.right = a.new TreeNode(3);

        String ans = a.isSymmetric(root) == 1 ? "true" : "false";
        System.out.println("Symmetric :" + ans);
    }

    public int isSymmetric(TreeNode a) {
        if (a == null)
            return 1;
        return isSymofAllLeftRightNodes(a.left, a.right);
    }

    private int isSymofAllLeftRightNodes(TreeNode A, TreeNode B){
        if(A==null && B == null)
            return 1;

        if(A==null || B ==null)
            return 0;

        if(A.val != B.val)
            return 0;

        int left = isSymofAllLeftRightNodes(A.left, B.right);
        int right = isSymofAllLeftRightNodes(A.right, B.left);

        if(left == 1 && right ==1)
            return 1;
        else
            return 0;

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
