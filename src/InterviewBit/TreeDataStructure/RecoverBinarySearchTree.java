package InterviewBit.TreeDataStructure;

import java.util.*;

public class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    public RecoverBinarySearchTree(){
        first = middle = last = prev = null;
    }
    public static void main(String[] args){
        RecoverBinarySearchTree a = new RecoverBinarySearchTree();
        TreeNode root = a.new TreeNode(4);
        root.left = a.new TreeNode(3);
        root.right = a.new TreeNode(5);
        root.left.left = a.new TreeNode(1);
        root.left.right = a.new TreeNode(2);
        root.right.right = a.new TreeNode(6);
        System.out.println(a.recoverTree(root));
    }

    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> ansList = new ArrayList<>();
        recover(A);

        if(first == null)
            return ansList;

        if(last ==null){
            ansList.add(middle.val);
            ansList.add(first.val);
        }else{
            ansList.add(last.val);
            ansList.add(first.val);
        }

        return ansList;
    }

    private void recover(TreeNode A){
        if(A ==null)
            return;

        recover(A.left);

        if(prev !=null && A.val < prev.val){
            if(first == null){
                first = prev;
                middle = A;
            }else{
                last = A;
            }
        }
        prev = A;

        recover(A.right);

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
