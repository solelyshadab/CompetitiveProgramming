package InterviewBit.TreeDataStructure;

import java.util.*;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPostorder a = new BinaryTreeFromInorderAndPostorder();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 8, 2, 5, 1, 6, 3, 7));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(8, 4, 5, 2, 6, 7, 3, 1));
        TreeNode result = a.createTree(A,B);
    }

    public TreeNode createTree(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<TreeNode> ansList = new ArrayList<>();

        Index pIndex = new Index();
        pIndex.index = B.size()-1;
        return tree(A,B,0, A.size()-1,pIndex);
    }

    private TreeNode tree(ArrayList<Integer> A, ArrayList<Integer> B,int inStart, int inEnd, Index postIndex){
        if(inStart>inEnd)
            return null;

        TreeNode node = new TreeNode(B.get(postIndex.index));
        (postIndex.index)--;

        if(inStart == inEnd)
            return node;

        int inIndex = searchRootIndex(A,inStart,inEnd, node.val);

        node.right = tree(A,B, inIndex+1, inEnd, postIndex);
        node.left = tree(A,B, inStart, inIndex-1, postIndex);

        return node;

    }

    private static int searchRootIndex(ArrayList<Integer> A, int inStart, int inEnd, int value){
        for(int i = inStart; i <= inEnd; i++){
            if(A.get(i).equals(value))
                return i;
        }

        return -1;
    }
    class Index
    {
        int index;
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
