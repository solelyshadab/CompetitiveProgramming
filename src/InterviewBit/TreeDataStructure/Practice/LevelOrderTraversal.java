package InterviewBit.TreeDataStructure.Practice;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args){
        LevelOrderTraversal a = new LevelOrderTraversal();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        System.out.println("Level Order using Queue: " + a.traverseLevel(root));
        System.out.println("Per Level Traversal Using Recursion :");
        for (ArrayList<Integer> ans: a.traverseEachLevelUsingRecursion(root)){
            System.out.println(ans);
        }
        System.out.println("Per Level Traversal Using Queue :");
        for (ArrayList<Integer> ans: a.traverseEachLevel(root)){
            System.out.println(ans);
        }
    }
    //Solution1: Using recursion...
    public ArrayList<ArrayList<Integer>> traverseEachLevelUsingRecursion(TreeNode root){
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        int height = height(root);
        for(int i = 1; i <= height; i++){
           ansList.add(perLevel(root, i, new ArrayList<>()));
        }

        return ansList;
    }

    public ArrayList<Integer> perLevel(TreeNode root, int height, ArrayList<Integer> ans){
        if (root == null)
            return ans;
        if(height ==1) {
            ans.add(root.data);
            return ans;
        }

        perLevel(root.left, height-1, ans);
        perLevel(root.right, height-1, ans);

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

    //Solution 2.a : Using Queue, prints all levels together
    public ArrayList<Integer> traverseLevel(TreeNode root){
        ArrayList<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode current = root;

        while(current !=null){
            ansList.add(current.data);
            if(current.left !=null)
                queue.add(current.left);
            if(current.right !=null)
                queue.add(current.right);
            current = queue.poll();
        }

        return ansList;
    }

    //Solution 2.b : Using Queue, prints each level separately
    public ArrayList<ArrayList<Integer>> traverseEachLevel(TreeNode root){
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true){

            int nodeCount = queue.size();

            if (nodeCount ==0)
                break;
            ArrayList<Integer> ans = new ArrayList<>();
            while (nodeCount >0){
                TreeNode current = queue.poll();
                ans.add(current.data);
                if(current.left !=null)
                    queue.add(current.left);
                if(current.right !=null)
                    queue.add(current.right);

                nodeCount--;
            }
            ansList.add(ans);
        }

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
