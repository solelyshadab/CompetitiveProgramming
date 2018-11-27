package CourseEra.Month3.HuffmanCode;

public class Node {
    int key;
    Node left, right;
    String code;
    int finalCode;

    public Node(int key){
        this.key = key;
        left = right = null;
        code = "";
        finalCode = -1;
    }
}
