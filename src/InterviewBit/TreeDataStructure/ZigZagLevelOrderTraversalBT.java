package InterviewBit.TreeDataStructure;

import java.util.*;


public class ZigZagLevelOrderTraversalBT {
    public static void main(String[] args){
        ZigZagLevelOrderTraversalBT a = new ZigZagLevelOrderTraversalBT();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        for (ArrayList<Integer> ans: a.zigzagUsingRecursion(root)){
            System.out.println(ans);
        }
    }

    public ArrayList<ArrayList<Integer>> zigzag(TreeNode root){
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);




        return ansList;
    }

    //Solution 1: Using stacks
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();

        boolean isLeft = true;
        currentStack.push(A);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!currentStack.empty()){

            TreeNode top = currentStack.pop();
            ans.add(top.data);

            if(isLeft){
                if(top.left !=null)
                    nextStack.push(top.left);
                if(top.right !=null)
                    nextStack.push(top.right);
            }else{
                if(top.right !=null)
                    nextStack.push(top.right);
                if(top.left !=null)
                    nextStack.push(top.left);
            }
            if(currentStack.empty()){
                isLeft = !isLeft;
                ansList.add(ans);
                Stack<TreeNode> tempStack = currentStack;
                currentStack = nextStack;
                nextStack = tempStack;
                ans = new ArrayList<>();
            }

        }

        return ansList;

    }



    //Solution 2: using recursion
    public ArrayList<ArrayList<Integer>> zigzagUsingRecursion(TreeNode root){
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        int height = height(root);
        for(int i = 1; i <= height; i++){
            if(i % 2 == 0)
                ansList.add(perLevelRight(root,i,new ArrayList<>()));
            else
            ansList.add(perLevelLeft(root, i, new ArrayList<>()));
        }

        return ansList;
    }

    public ArrayList<Integer> perLevelLeft(TreeNode root, int height, ArrayList<Integer> ans){
        if (root == null)
            return ans;
        if(height ==1) {
            ans.add(root.data);
            return ans;
        }

        perLevelLeft(root.left, height-1, ans);
        perLevelLeft(root.right, height-1, ans);

        return ans;
    }

    public ArrayList<Integer> perLevelRight(TreeNode root, int height, ArrayList<Integer> ans){
        if (root == null)
            return ans;
        if(height ==1) {
            ans.add(root.data);
            return ans;
        }

        perLevelRight(root.right, height-1, ans);
        perLevelRight(root.left, height-1, ans);

        return ans;
    }


    private static int height(TreeNode root){
        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight > rightHeight)
            return leftHeight+1;
        else
            return rightHeight+1;
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
