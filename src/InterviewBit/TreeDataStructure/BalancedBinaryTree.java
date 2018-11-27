package InterviewBit.TreeDataStructure;

public class BalancedBinaryTree {

    public static void main(String[] args){
        BalancedBinaryTree a = new BalancedBinaryTree();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.left.left = a.new TreeNode(3);
        root.left.left.left = a.new TreeNode(4);
        root.left.left.right = a.new TreeNode(5);
        root.left.right = a.new TreeNode(6);
        root.right = a.new TreeNode(7);
        root.right.left = a.new TreeNode(8);
        root.right.right = a. new TreeNode(9);

        System.out.println(a.isBalancedTree(root, a.new Height()));
    }

    class Height{
        int height;
    }
    // Solution 1: Runs in O(n), needs n space for height.
    public boolean isBalancedTree(TreeNode A, Height height ){
        if(A==null) {
            height.height = 0;
            return true;
        }

        Height rightHeight = new Height();
        Height leftHeight = new Height();

        boolean isLeftBalanced = isBalancedTree(A.left, leftHeight);
        boolean isRightBalanced = isBalancedTree(A.right, rightHeight);

        if(leftHeight.height > rightHeight.height)
        height.height =leftHeight.height + 1;
        else height.height = rightHeight.height +1;

        return (Math.abs(leftHeight.height - rightHeight.height) <= 1 && isLeftBalanced && isRightBalanced);

    }


    // Solution 2: Uses 2 recursion methods, running time of O(n^2)
    public boolean isBalanced(TreeNode A){
        if(A==null)
            return true;

        int leftHeight = height(A.left);
        int righHeight = height(A.right);

        return (Math.abs(leftHeight - righHeight) <=1 && isBalanced(A.left) && isBalanced(A.right));
    }

    private int height(TreeNode A){
        if(A==null)
            return 0;

        int leftHeight = height(A.left);
        int rightHeight = height(A.right);

        if(leftHeight > rightHeight)
            return leftHeight +1;
        else
            return rightHeight+1;
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
