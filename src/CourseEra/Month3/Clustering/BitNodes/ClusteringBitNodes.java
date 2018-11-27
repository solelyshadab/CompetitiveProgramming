package CourseEra.Month3.Clustering.BitNodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class ClusteringBitNodes {
    int K;
    int bitSize;
    Hashtable<Integer, Node> nodeMap = new Hashtable();
    //TODO: Not getting correct answer on Large Data Set, need to revisit.
    public static void main(String[] args) {
        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Clustering_BitNodes_LargeData.txt");
        ClusteringBitNodes clusteringBitNodes = new ClusteringBitNodes();
        UnionFindBitNodes unionFindBitNodes = new UnionFindBitNodes();

        clusteringBitNodes.loadEdges(file, unionFindBitNodes);
        clusteringBitNodes.clusterforOneBitDiff(unionFindBitNodes);
        clusteringBitNodes.clusterforTwoBitDiff(unionFindBitNodes);

        System.out.println("No of clusters is: " + clusteringBitNodes.K);
    }

    private void clusterforTwoBitDiff(UnionFindBitNodes unionFind) {

        Set<Integer> keys = nodeMap.keySet();
        for (Integer key : keys) {
            Node node = nodeMap.get(key);
            OUTERLOOP:
            for (int i = 0; i < bitSize; i++) {

                String nodeValue = node.value;
                StringBuilder newNodeValue = new StringBuilder(nodeValue);
                char a = newNodeValue.charAt(i);
                if (a == '0') {
                    newNodeValue.setCharAt(i, '1');
                } else {
                    newNodeValue.setCharAt(i, '0');
                }

                for(int j = 0; j < bitSize; j++) {

                    //Revert the changes done in String by inner loop
                    StringBuilder newNodeValueofJ = new StringBuilder(newNodeValue.toString());
                    if(i!=j) {
                        char b = newNodeValueofJ.charAt(j);
                        if (b == '0') {
                            newNodeValueofJ.setCharAt(j, '1');
                        } else {
                            newNodeValueofJ.setCharAt(j, '0');
                        }
                    }
                    else {
                        continue;
                    }

                    int newkey = newNodeValueofJ.toString().hashCode();
                    if (nodeMap.containsKey(newkey)) {

                        if (unionFind.findSet(nodeMap.get(newkey)) != unionFind.findSet(node)) {
                            unionFind.Union(node, nodeMap.get(newkey));
                            K--;
                            break OUTERLOOP;
                        }
                    }

                }

            }
        }
    }

    private void clusterforOneBitDiff(UnionFindBitNodes unionFind) {

        Set<Integer> keys = nodeMap.keySet();
        for (Integer key : keys) {
            Node node = nodeMap.get(key);
            if(node.value.length() < bitSize)
                System.out.println("Error String: " + node.value);
            for (int i = 0; i < bitSize; i++) {
                String nodeValue = node.value;

                char a = nodeValue.charAt(i);
                StringBuilder newNodeValue = new StringBuilder(nodeValue);
                if (a == '0') {
                    newNodeValue.setCharAt(i, '1');
                } else {
                    newNodeValue.setCharAt(i, '0');
                }

                int newkey = newNodeValue.toString().hashCode();
                if (nodeMap.containsKey(newkey)) {

                    if (unionFind.findSet(nodeMap.get(newkey)) != unionFind.findSet(node)) {
                        unionFind.Union(node, nodeMap.get(newkey));
                        K--;
                        break;
                    }
                }

            }
        }
    }

    private void loadEdges(File file, UnionFindBitNodes unionFind) {
        try (Scanner scanner = new Scanner(file)) {

            int totalVertices = scanner.nextInt();
            bitSize = scanner.nextInt();
            K = totalVertices;
            //scanner.nextLine();
            while (scanner.hasNextLine()) {
                String nodeValue = scanner.nextLine();
                if(nodeValue.length() < bitSize){
                    nodeValue += scanner.nextLine();
                }

                nodeValue = nodeValue.replaceAll("\\s+", "");
                if (!nodeValue.equals("")) {
                    int key = nodeValue.hashCode();
                    Node node = new Node(nodeValue);
                    unionFind.makeSet(node);
                    if (nodeMap.containsKey(key)) {
                        unionFind.Union(node, nodeMap.get(key));
                        //nodeMap.put(key, node);
                        K--;
                    } else {
                        nodeMap.put(key, node);
                    }
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
