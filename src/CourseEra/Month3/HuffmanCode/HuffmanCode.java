package CourseEra.Month3.HuffmanCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HuffmanCode {
    int totalVertices;
    Node finalTree;
    ArrayList<Node> frequencyList = new ArrayList<>();
    ArrayList<Node> verticesList = new ArrayList<>();
    String tempCode = "";

    public static void main(String[] args){
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/HuffmanCode_LargeData.txt");
        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.readFile(file);
        huffmanCode.mainLoop();
        huffmanCode.assignCodes(huffmanCode.finalTree);
        Collections.sort(huffmanCode.verticesList, new Comparator<Node>() {
            public int compare(Node c1, Node c2) {
                if (c1.code.length() < c2.code.length()) return -1;
                if (c1.code.length() > c2.code.length()) return 1;
                return 0;
            }});
        for(int i = 0; i < huffmanCode.verticesList.size(); i++){
            System.out.println("Vertice: " + huffmanCode.verticesList.get(i).key + " Code: " + huffmanCode.verticesList.get(i).code);
        }

        System.out.println("Minimum code size : " + huffmanCode.verticesList.get(0).code.length());
        System.out.println("Maximum code size : " + huffmanCode.verticesList.get(huffmanCode.verticesList.size()-1).code.length());
    }

    private void assignCodes(Node node){
        if(node.left == null || node.right == null)
            return;

        node.left.code = node.code + node.left.code;
        node.right.code = node.code + node.right.code;

        assignCodes(node.left);
        assignCodes(node.right);
    }

    private void mainLoop(){

        for(int i = 0; i < totalVertices-1; i++){
            Collections.sort(frequencyList, new Comparator<Node>() {
                public int compare(Node c1, Node c2) {
                    if (c1.key < c2.key) return -1;
                    if (c1.key > c2.key) return 1;
                    return 0;
                }});
            int extractMin = frequencyList.get(0).key + frequencyList.get(1).key;
            Node node = new Node(extractMin);
            node.left = frequencyList.get(0);
            node.left.code = "0";
            node.right = frequencyList.get(1);
            node.right.code = "1";
            frequencyList.remove(0);
            frequencyList.remove(0);
            frequencyList.add(node);
        }
        finalTree = frequencyList.get(0);
    }

    private void readFile(File file){
        try(Scanner scanner = new Scanner(file)){
            totalVertices = scanner.nextInt();
            while (scanner.hasNext()){
                int vertice = scanner.nextInt();
                Node node = new Node(vertice);
                frequencyList.add(node);
                verticesList.add(node);
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
