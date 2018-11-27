package CourseEra.Month3.PrimsMST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// TODO : This is incomplete, need to think about how to solve using Heaps
public class PrimsMST {

    public static void main(String args[]){

        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/PrimsMST_SmallData.txt");
        PrimsMST primsMST = new PrimsMST();
        primsMST.loadFile(file);
    }

    private void loadFile(File file){
        try{
            Scanner scanner = new Scanner(file);
            int totalNodes = scanner.nextInt();
            int totalEdges = scanner.nextInt();
            MinHeap minHeap = new MinHeap();

            int rootU = scanner.nextInt();
            int rootV = scanner.nextInt();
            int rootKey = scanner.nextInt();
            minHeap.root = new Node(rootKey);
            minHeap.root.setU(rootU);
            minHeap.root.setV(rootV);

            while (scanner.hasNext()){

                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int key = scanner.nextInt();
                insertInMinHeap(minHeap.root, key, u,v);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void insertInMinHeap(Node node,int item, int u, int v){
        if(node.left != null && node.right !=null) {
            if(item >= node.left.key)
                insertInMinHeap(node.left, item, u, v);
            else
                insertInMinHeap(node.right, item, u, v);
        }
        else{
            if(node.left == null) {
                node.left = new Node(item);
                node.left.setParentNode(node);
                node.left.setU(u);
                node.left.setV(v);
                bubbleUpinMinHeap(node.left);
            }
            else{
                node.right = new Node(item);
                node.right.setParentNode(node);
                node.left.setU(u);
                node.left.setV(v);
                bubbleUpinMinHeap(node.right);
            }
        }
    }

    private void bubbleUpinMinHeap(Node node){
        if(node.parent == null)
            return;
        if(node.key > node.parent.key)
            return;

        int tempKey = node.key;
        int tempU = node.u;
        int tempV = node.v;

        node.key = node.parent.key;
        node.u = node.parent.u;
        node.v = node.parent.v;

        node.parent.key = tempKey;
        node.parent.u = tempU;
        node.parent.v = tempV;
        bubbleUpinMinHeap(node.parent);
    }
}
