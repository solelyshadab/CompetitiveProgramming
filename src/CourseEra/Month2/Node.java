package CourseEra.Month2;

public class Node {
    int key;
    Node left, right;
    Node parent;

    public Node(int key){
        this.key = key;
        left = right = null;
        parent = null;
    }

    public void setParentNode(Node parent){
        this.parent = parent;
    }

}
