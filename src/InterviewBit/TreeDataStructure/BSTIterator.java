package InterviewBit.TreeDataStructure;

import java.util.Stack;

public class BSTIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        BSTIterator a = new BSTIterator(root);
        for(int i = 0; i < 6 ; i++) {
            System.out.println(a.next());
            System.out.println(a.hasNext());
        }

        System.out.println(a.hasNext());
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode current;

    public BSTIterator(TreeNode A) {

        while (!stack.empty())
            stack.pop();

        TreeNode current = A;
        while (current != null){
            stack.push(current);
            current = current.left;
        }
    }

    public int next() {
        if(stack.empty())
        return -1;

        current = stack.pop();
        int ans = current.val;

        current = current.right;

        while (current !=null){
            stack.push(current);
            current = current.left;
        }

        return ans;
    }

    public boolean hasNext(){
        return !stack.empty();
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
}
