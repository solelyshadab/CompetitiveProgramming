package CourseEra.Month3.PrimsMST;

public class Node {
    int key;
    Node left, right;
    Node parent;
    int u;
    int v;

    public Node(int key){
        this.key = key;
        left = right = null;
        parent = null;
    }

    public void setParentNode(Node parent){
        this.parent = parent;
    }

    public void setU(int u){
        this.u = u;
    }
    public void setV(int v){
        this.v = v;
    }
}
