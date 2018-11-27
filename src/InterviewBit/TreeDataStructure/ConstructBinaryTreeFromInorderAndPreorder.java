package InterviewBit.TreeDataStructure;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPreorder {
    private int preIndex;

    public ConstructBinaryTreeFromInorderAndPreorder(){
        preIndex =0;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPreorder a = new ConstructBinaryTreeFromInorderAndPreorder();
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(2,1,3));
        ArrayList<Integer> pre = new ArrayList<>(Arrays.asList(1,2,3));
        TreeNode result = a.buildTree(pre,in);
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        return tree(A,B,0,A.size()-1);
    }


    private TreeNode tree(ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd){
        if(inStart > inEnd)
            return null;

        TreeNode node = new TreeNode(A.get(preIndex));
        preIndex++;

        if(inStart == inEnd)
            return node;

        int inIndex = inIndex(B,inStart, inEnd, node.val);
        node.left = tree(A,B, inStart, inIndex-1);
        node.right = tree(A,B, inIndex+1, inEnd);

        return node;

    }

    private static int inIndex(ArrayList<Integer> B, int start, int end, int value){
        for(int i = start; i <=end; i++){
            if(B.get(i).equals(value)){
                return i;
            }
        }

        return -1;
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
