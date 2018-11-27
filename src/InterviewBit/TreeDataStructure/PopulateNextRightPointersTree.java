package InterviewBit.TreeDataStructure;

public class PopulateNextRightPointersTree {
    Node root;

    public static void main(String args[])
    {

         /* Constructed binary tree is
                 10
               /   \
             8      2
           /         \
         3            90
        */
        PopulateNextRightPointersTree tree = new PopulateNextRightPointersTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.right.right = new Node(90);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        int a = tree.root.nextRight != null ?
                tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null ?
                tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null ?
                tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null ?
                tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null ?
                tree.root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        System.out.println("nextRight of " + tree.root.left.data
                + " is " + b);
        System.out.println("nextRight of " + tree.root.right.data +
                " is " + c);
        System.out.println("nextRight of " + tree.root.left.left.data +
                " is " + d);
        System.out.println("nextRight of " + tree.root.right.right.data +
                " is " + e);
    }
    void connect(Node root) {
        Node temp = null;

        if (root == null)
            return;

        // Set nextRight for root
        root.nextRight = null;

        // set nextRight of all levels one by one
        while (root != null)
        {
            Node current = root;

            /* Connect all childrem nodes of p and children nodes of all other
               nodes at same level as p */
            while (current != null)
            {
                // Set the nextRight pointer for p's left child
                if (current.left != null)
                {
                    if (current.right != null)
                        current.left.nextRight = current.right;
                    else
                        current.left.nextRight = getNextRight(current);
                }

                if (current.right != null)
                    current.right.nextRight = getNextRight(current);

                // Set nextRight for other nodes in pre order fashion
                current = current.nextRight;
            }

            // start from the first node of next level
            if (root.left != null)
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = getNextRight(root);
        }
    }



    Node getNextRight(Node node)
    {
        Node temp = node.nextRight;

        /* Traverse nodes at p's level and find and return
           the first node's first child */
        while (temp != null)
        {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.nextRight;
        }

        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }

    static class Node
    {
        int data;
        Node left, right, nextRight;

        Node(int item)
        {
            data = item;
            left = right = nextRight = null;
        }
    }
}
