package CourseEra.Month2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapMedians {
    int minHeapSize = 1;
    int maxHeapSize = 1;
    int medianArray[] = new int[10000];
    int medianSum;

    public static void main(String args[]){

        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Median_Maintenance_LargeData.txt");
        HeapMedians heapMedians = new HeapMedians();
        heapMedians.loadFile(file);

        System.out.println("Median Sum modulo of 10000 : " + heapMedians.medianSum % 10000);
    }

    private void loadFile(File file){

        try(Scanner scanner = new Scanner(file)){

            int root1 = scanner.nextInt();
            medianArray[0] = root1;
            medianSum = root1;
            int root2 = scanner.nextInt();
            MaxHeap maxHeap = new MaxHeap();
            MinHeap minHeap = new MinHeap();

            if(root1<= root2) {
                maxHeap.root = new Node(root1);
                minHeap.root = new Node(root2);
                medianArray[1] = root1;
                medianSum += medianArray[1];
            }
            else {
                maxHeap.root = new Node(root2);
                minHeap.root = new Node(root1);
                medianArray[1] = root2;
                medianSum += medianArray[1];
            }
            int i = 2;
            while (scanner.hasNextLine()){
                loadHeap(maxHeap, minHeap,scanner.nextInt());
                if(maxHeapSize>= minHeapSize) {
                    medianArray[i] = maxHeap.root.key;
                    medianSum += medianArray[i];
                    i++;
                }
                else{
                    medianArray[i] = minHeap.root.key;
                    medianSum += medianArray[i];
                    i++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadHeap(MaxHeap maxHeap, MinHeap minHeap, int item){
        if(item < maxHeap.root.key){
            insertInMaxHeap(maxHeap.root, item);
               maxHeapSize++;
        }
        else{
            insertInMinHeap(minHeap.root, item);
                minHeapSize++;
        }
        // Balance the two heaps if it is not
        if(maxHeapSize > minHeapSize + 1 ){
                //sizediff would be 2 if new item inserted, hence pluck out root of maxHeap and insert in minHeap
                insertInMinHeap(minHeap.root, maxHeap.root.key);
                minHeapSize++;
                // Delete root of HeapMax and replace with lowest available
                bubbleDowninMaxHeap(maxHeap.root);
                maxHeapSize--;
            }
            else if(minHeapSize > maxHeapSize + 1){
            //sizediff would be 2 if new item is inserted, hence pluck out of root of minHeap and insert in maxHeap
                insertInMaxHeap(maxHeap.root, minHeap.root.key);
            maxHeapSize++;
            // Delete root of HeapMin and replace with highest available
                bubbleDowninMinHeap(minHeap.root);
            minHeapSize--;
        }


    }

    private void insertInMaxHeap(Node node,int item){

            if(node.left != null && node.right !=null) {
                if(item <= node.left.key)
                insertInMaxHeap(node.left, item);
                else
                    insertInMaxHeap(node.right, item);
            }
            else{
                if(node.left == null) {
                    node.left = new Node(item);
                    node.left.setParentNode(node);
                    bubbleUpinMaxHeap(node.left);
                }
                else {
                    node.right = new Node(item);
                    node.right.setParentNode(node);
                    bubbleUpinMaxHeap(node.right);
                }
            }
    }

    private void bubbleUpinMaxHeap(Node node){
        if(node.parent == null)
        return;
        if(node.key < node.parent.key)
            return;

        int tempKey = node.key;
        node.key = node.parent.key;
        node.parent.key = tempKey;

        bubbleUpinMaxHeap(node.parent);
    }

    private void insertInMinHeap(Node node,int item){
        if(node.left != null && node.right !=null) {
            if(item >= node.left.key)
            insertInMinHeap(node.left, item);
            else
                insertInMinHeap(node.right, item);
        }
        else{
            if(node.left == null) {
                node.left = new Node(item);
                node.left.setParentNode(node);
                bubbleUpinMinHeap(node.left);
            }
            else{
                node.right = new Node(item);
                node.right.setParentNode(node);
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
        node.key = node.parent.key;
        node.parent.key = tempKey;
        bubbleUpinMinHeap(node.parent);
    }

    private void bubbleDowninMinHeap(Node node){
        if(node.right == null && node.left == null) {
            node.setParentNode(null);
            return;
        }
        if(node.left == null){
            int tempKey = node.key;
            node.key = node.right.key;
            node.right.key = tempKey;
            if(node.right.right == null && node.right.left == null) {
                node.right.setParentNode(null);
                node.right =null;
                return;
            }else
            bubbleDowninMinHeap(node.right);
        }
        if(node.right == null){
            int tempKey = node.key;
            node.key = node.left.key;
            node.left.key = tempKey;
            if(node.left.right == null && node.left.left == null) {
                node.left.setParentNode(null);
                node.left =null;
                return;
            }else
            bubbleDowninMinHeap(node.left);
        }

        if(node.right !=null && node.left!=null) {
            int tempKey = node.key;

            if (node.left.key < node.right.key) {
                node.key = node.left.key;
                node.left.key = tempKey;
                if(node.left.right == null && node.left.left == null) {
                    node.left.setParentNode(null);
                    node.left =null;
                    return;
                }else
                bubbleDowninMinHeap(node.left);
            } else {
                node.key = node.right.key;
                node.right.key = tempKey;
                if(node.right.right == null && node.right.left == null) {
                    node.right.setParentNode(null);
                    node.right =null;
                    return;
                }else
                bubbleDowninMinHeap(node.right);
            }
        }

    }

    private void bubbleDowninMaxHeap(Node node) {
        //Very unlikely for root of unbalanace heap to not have any left or right Nodes(below conditions should not occur)
        if (node.right == null && node.left == null) {
            node.setParentNode(null);
            return;
        }

        if (node.left == null) {
            int tempKey = node.key;
            node.key = node.right.key;
            node.right.key = tempKey;
            if(node.right.right == null && node.right.left == null) {
                node.right.setParentNode(null);
                node.right =null;
                return;
            }else
            bubbleDowninMaxHeap(node.right);
        }
        else if (node.right == null) {
            int tempKey = node.key;
            node.key = node.left.key;
            node.left.key = tempKey;
            if(node.left.right == null && node.left.left == null) {
                node.left.setParentNode(null);
                node.left =null;
                return;
            }else
            bubbleDowninMaxHeap(node.left);
        }
        if (node.right != null && node.left != null) {
            int tempKey = node.key;
            if (node.left.key > node.right.key) {
                node.key = node.left.key;
                node.left.key = tempKey;
                if(node.left.right == null && node.left.left == null) {
                    node.left.setParentNode(null);
                    node.left =null;
                    return;
                }else
                bubbleDowninMaxHeap(node.left);
            }
            else {
                node.key = node.right.key;
                node.right.key = tempKey;
                if(node.right.right == null && node.right.left == null) {
                    node.right.setParentNode(null);
                    node.right =null;
                    return;
                }else
                bubbleDowninMaxHeap(node.right);
            }
        }
    }

}


