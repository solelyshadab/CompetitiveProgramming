package InterviewBit.TreeDataStructure;

public class PathSum {
    public static void main(String[] args) {
        PathSum a = new PathSum();
        TreeNode root = a.new TreeNode(1000);
        root.left = a.new TreeNode(200);
//        root.right = a.new TreeNode(3);
//        root.left.left = a.new TreeNode(4);
//        root.left.right = a.new TreeNode(5);
//        root.right.left = a.new TreeNode(6);
        boolean ans = a.hasPathSum(root, 1000) == 1;
        System.out.println(ans);
    }


    public int hasPathSum(TreeNode a, int b) {
        if (a == null)
            return 0;
        if (a.val == b && (a.left == null && a.right == null))
            return 1;

        b -= a.val;
        if (hasPathSum(a.left, b) == 1
                || hasPathSum(a.right, b) == 1)
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
