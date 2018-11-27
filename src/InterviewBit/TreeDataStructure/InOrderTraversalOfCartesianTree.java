package InterviewBit.TreeDataStructure;

import java.util.*;

public class InOrderTraversalOfCartesianTree {
    public static void main(String[] args){
        InOrderTraversalOfCartesianTree a = new InOrderTraversalOfCartesianTree();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,5,10,40,30,15,28,20));

    }

    public TreeNode buildCartesian(ArrayList<Integer> A,int start, int end){
        if(start > end)
            return null;

        int maxIndex = maxIndex(A, start,end);

        TreeNode node = new TreeNode(A.get(maxIndex));

        if(start==end)
            return node;

        node.left = buildCartesian(A,start, maxIndex-1);
        node.right = buildCartesian(A,maxIndex+1, end);

        return node;
    }

    private static int maxIndex(ArrayList<Integer> A, int start, int end){
        int max = A.get(start);
        int maxIndex = start;
        for(int i = start+1; i <= end; i++){
            if(A.get(i) > max){
                max = A.get(i);
                maxIndex = i;
            }
        }

        return maxIndex;
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
