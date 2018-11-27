package InterviewBit.TreeDataStructure;

import java.util.*;

public class KthSmallestElementInBST {

    public static void main(String[] args){
        KthSmallestElementInBST a = new KthSmallestElementInBST();
        TreeNode root = a.new TreeNode(4);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(5);
        root.left.left = a.new TreeNode(1);
        root.left.right = a.new TreeNode(3);
        root.right.right = a.new TreeNode(6);

        System.out.println(a.find(root,6));
    }

    public int find(TreeNode A, int K){
       Stack<TreeNode> stack = new Stack<>();
       int count =0;

       TreeNode currNode = A;

       while(!stack.empty() || currNode !=null){
           if(currNode !=null){
               stack.push(currNode);
               currNode = currNode.left;
           }else{
               TreeNode temp = stack.pop();
               count++;
               if(count == K){
                   return temp.val;
               }
               currNode = temp.right;
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
