package InterviewBit.TreeDataStructure.Practice;

public class MergeBinaryTrees {

    public static void main(String... args){
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        root1.left.left = new Node(5);

        Node root2 = new Node(3);
        root2.left = new Node(6);
        root2.right = new Node(1);
        root2.left.right = new Node(2);
        root2.right.right = new Node(7);

        Node mergedTree = new MergeBinaryTrees().merge(root1,root2);
        System.out.println("Merged Tree is :");
    }

    //Solution 1: This is my solution, works fine
    public Node merge(Node root1, Node root2){
        if (root2 == null)
            return root1;

        if(root1.left == null && root1.right == null){
            root1.left = root2.left;
            root1.right = root2.right;
            root1.value += root2.value;
            return root1;
        }

        if (root1.left == null){
            root1.left = root2.left;
            root1.value += root2.value;
            return root1;
        }

        if(root1.right == null){
            root1.right = root2.right;
            root1.value += root2.value;
            return root1;
        }

        root1.value += root2.value;
        merge(root1.left,root2.left);
        merge(root1.right,root2.right);

        return root1;
    }

    //Solution2: geeksfor geeks solution, crisper code
    public Node merge1(Node root1, Node root2){
        if (root1==null)
            return root2;

        if (root2 == null)
            return root1;

        root1.value += root2.value;

        root1.left = merge1(root1.left, root2.left);
        root2.right = merge1(root1.right, root2.right);

        return root1;
    }


    static class Node{
        int value;
        Node left;
        Node right;

        public  Node(int value){
            this.value = value;
            left = right = null;
        }
    }

}
