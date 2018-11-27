package CourseEra.Month2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryTreeMedians {

    public static void main(String args[]){

        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Median_BinaryTree.txt");
        BinaryTreeMedians binaryTreeMedians = new BinaryTreeMedians();
        binaryTreeMedians.loadFile(file, binaryTreeMedians);
    }

    private void loadFile(File file, BinaryTreeMedians binaryTreeMedians){

        try(Scanner scanner = new Scanner(file)){

            int root = scanner.nextInt();
            BinaryTree binaryTree = new BinaryTree(root);

            while (scanner.hasNextLine()){
                loadTreeData(binaryTree.root,scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadTreeData(Node node, int item){
        if(item<= node.key){
            if(node.left == null) {
                node.left = new Node(item);
                return;
            }
            else
                loadTreeData(node.left, item);
        }

        else{
            if(node.right == null) {
                node.right = new Node(item);
                return;
            }
            else
                loadTreeData(node.right, item);
        }

    }
}
