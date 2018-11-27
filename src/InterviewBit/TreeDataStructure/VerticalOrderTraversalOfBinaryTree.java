package InterviewBit.TreeDataStructure;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    static int min;
    static int max;

    public static void main(String args[]) {
        VerticalOrderTraversalOfBinaryTree a = new VerticalOrderTraversalOfBinaryTree();
        /* Let us construct the tree shown in above diagram */
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        root.right.right = a.new TreeNode(7);
        root.right.left.right = a.new TreeNode(8);
        root.right.right.right = a.new TreeNode(9);
        a.solution(root);
        System.out.println("Min: " + min + " Max: " + max);
        System.out.println(a.solution(root));
    }


    public ArrayList<Integer> solution(TreeNode root) {
        ArrayList<Integer> ansList = new ArrayList<>();
        findMinMax(root,0);

        for(int i = min; i <= max; i++){
            ansList = traverseVertical(root,i,0, ansList);
        }

        return ansList;
    }

    private ArrayList<Integer> traverseVertical(TreeNode root,int index, int hd, ArrayList<Integer> ansList){
        if(root == null)
            return ansList;

        if(index == hd )
            ansList.add(root.data);

        traverseVertical(root.left, index, hd-1, ansList);
        traverseVertical(root.right, index, hd +1, ansList);

        return ansList;
    }

    private static void findMinMax(TreeNode root, int hd){
        if(root == null)
            return;

        if(hd < min)
            min =hd;

        else if(hd > max)
            max = hd;

        findMinMax(root.left, hd - 1 );
        findMinMax(root.right,hd + 1);

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
