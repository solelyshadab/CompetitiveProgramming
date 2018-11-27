package InterviewBit.TreeDataStructure;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList a = new FlattenBinaryTreeToLinkedList();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.left.left = a.new TreeNode(3);
        root.left.left.left = a.new TreeNode(4);
        root.left.left.right = a.new TreeNode(5);
        root.left.right = a.new TreeNode(6);
        root.right = a.new TreeNode(7);
        root.right.left = a.new TreeNode(8);
        root.right.right = a. new TreeNode(9);

        TreeNode result = a.flatten(root);
    }

    public TreeNode flatten(TreeNode a){
        if(a ==null)
            return a;

        flatten(a.left);
        flatten(a.right);
        if(a.left !=null){
            TreeNode prevRightNode = a.right;
            a.right = a.left;
            a.left = null;
            TreeNode current = a.right;
            while( current.right !=null){
                current = current.right;
            }
            current.right = prevRightNode;
        }
        return a;
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
