package InterviewBit.TreeDataStructure;

public class IdenticalBinaryTrees {
    public static void main(String[] args){
        IdenticalBinaryTrees a = new IdenticalBinaryTrees();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        TreeNode root2 = a.new TreeNode(1);
        root2.left = a.new TreeNode(2);
        root2.right = a.new TreeNode(3);
        root2.left.left = a.new TreeNode(4);
        root2.left.right = a.new TreeNode(5);
        root2.right.left = a.new TreeNode(6);
        String ans = a.isIdenticalUtil(root, root2) == 1 ? "true" : "false";
        System.out.println("Identical :" + ans);
    }

    public int isIdenticalUtil(TreeNode A, TreeNode B){
        return isIdentical(A,B,1);
    }

    private static int isIdentical(TreeNode A, TreeNode B, int ans){
        if(A == null && B == null){
            return ans;
        }
        if(A==null || B == null || A.val != B.val ){
            ans = 0;
            return ans;
        }

        ans =  isIdentical(A.left, B.left,ans);
        ans = isIdentical(A.right, B.right,ans);

        return ans;
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
