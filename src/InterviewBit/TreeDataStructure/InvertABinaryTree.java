package InterviewBit.TreeDataStructure;

public class InvertABinaryTree {
    public static void main(String[] args){
        InvertABinaryTree a = new InvertABinaryTree();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        TreeNode reverse = mirror(root);
    }

    public static TreeNode mirror(TreeNode root){
        if(root == null)
            return root;

        TreeNode left =  mirror(root.left);
        TreeNode right = mirror(root.right);

        root.right = left;
        root.left = right;

        return root;
    }


    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
