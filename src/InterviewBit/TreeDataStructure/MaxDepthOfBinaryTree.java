package InterviewBit.TreeDataStructure;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args){
        MaxDepthOfBinaryTree a = new MaxDepthOfBinaryTree();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        System.out.println(a.maxDepth(root));
    }

    public int maxDepth(TreeNode A){
        if(A==null)
            return 0;

        int leftDepth = maxDepth(A.left);
        int rightDepth = maxDepth(A.right);

        return Math.max(leftDepth, rightDepth) + 1;
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
