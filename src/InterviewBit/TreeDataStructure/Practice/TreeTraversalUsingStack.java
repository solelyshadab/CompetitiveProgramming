package InterviewBit.TreeDataStructure.Practice;

import java.util.*;

public class TreeTraversalUsingStack {
    public static void main(String[] args){
        TreeTraversalUsingStack a = new TreeTraversalUsingStack();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        root.right.right = a.new TreeNode(7);
        //System.out.println("InOrder traversal: " + a.inOrderTraversal(root));
        //System.out.println("PreOrder traversal: " + a.preOrderTraversal(root));
        System.out.println("PostOrder traversal - 2 Stacks: " + a.postOrderTraversal(root));
        System.out.println("PostOrder traversal - 1 Stacks: " + a.postOrderIterative(root));
    }

    public ArrayList<Integer> inOrderTraversal(TreeNode A){
        ArrayList<Integer> ansList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        if(A == null)
            return ansList;

        while(!stack.empty() || current != null){
            if(current !=null){
                stack.add(current);
                current = current.left;
            }else{
                TreeNode temp = stack.pop();
                ansList.add(temp.val);
                current = temp.right;
            }
        }

        return ansList;
    }

    public ArrayList<Integer> preOrderTraversal(TreeNode A){
        ArrayList<Integer> ansList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        if(A == null)
            return ansList;

        while(!stack.empty() || current != null){
            if(current !=null){
                ansList.add(current.val);
                stack.add(current);
                current = current.left;
            }else{
                TreeNode temp = stack.pop();
                //ansList.add(temp.val);
                current = temp.right;
            }
        }

        return ansList;
    }

    // Solution1: Using Two stacks
    public ArrayList<Integer> postOrderTraversal(TreeNode A){
        ArrayList<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if(A == null)
            return ansList;

        // Push root to 1st stack
        stack1.push(A);
        //while stack1 is not empty
//        2.1 Pop a node from first stack and push it to second stack
//        2.2 Push left and right children of the popped node to first stack
        while (!stack1.empty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if(temp.left !=null)
            stack1.push(temp.left);
            if(temp.right !=null)
            stack1.push(temp.right);
        }

        while (!stack2.empty()){
            ansList.add(stack2.pop().val);
        }


        return ansList;
    }
    //Solution1: Using Two stacks
    public ArrayList<Integer> postOrderIterative(TreeNode A)
    {
        ArrayList<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();

        // Check for empty tree
        if (A == null)
            return ansList;
        S.push(A);
        TreeNode prev = null;
        while (!S.isEmpty())
        {
            TreeNode current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current)
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    ansList.add(current.val);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            }
            else if (current.left == prev)
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    ansList.add(current.val);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            }
            else if (current.right == prev)
            {
                S.pop();
                ansList.add(current.val);
            }

            prev = current;
        }

        return ansList;
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
