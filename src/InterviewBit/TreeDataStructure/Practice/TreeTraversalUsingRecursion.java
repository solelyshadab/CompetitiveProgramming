package InterviewBit.TreeDataStructure.Practice;

import java.util.*;

public class TreeTraversalUsingRecursion {
    public static void main(String args[]) {
        TreeTraversalUsingRecursion a = new TreeTraversalUsingRecursion();
        /* Let us construct the tree shown in above diagram */
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        System.out.println("Depth First Search:");
        System.out.println("InOrder Traversal: " + inOrderTraversal(root, new ArrayList<>()));
        System.out.println("preOrder Traversal: " + preOrderTraversal(root, new ArrayList<>()));
        System.out.println("PostOrder Traversal: " + postOrderTraversal(root, new ArrayList<>()));
        System.out.println("\n" + "Breadth First Search:");

    }

    // Depth First Search
    public static ArrayList<Integer> inOrderTraversal(TreeNode root, ArrayList<Integer> ansList) {
        if (root == null)
            return ansList;

        inOrderTraversal(root.left, ansList);
        ansList.add(root.data);
        inOrderTraversal(root.right, ansList);

        return ansList;
    }

    // Depth First Search
    public static ArrayList<Integer> preOrderTraversal(TreeNode root, ArrayList<Integer> ansList) {
        if (root == null)
            return ansList;
        ansList.add(root.data);
        preOrderTraversal(root.left, ansList);
        preOrderTraversal(root.right, ansList);

        return ansList;
    }

    // Depth First Search
    public static ArrayList<Integer> postOrderTraversal(TreeNode root, ArrayList<Integer> ansList) {
        if (root == null)
            return ansList;

        postOrderTraversal(root.left, ansList);
        postOrderTraversal(root.right, ansList);
        ansList.add(root.data);

        return ansList;
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
