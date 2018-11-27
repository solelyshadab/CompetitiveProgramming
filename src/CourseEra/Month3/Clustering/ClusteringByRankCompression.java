package CourseEra.Month3.Clustering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ClusteringByRankCompression {
    private List<Edge> edgeList = new ArrayList<>();
    private int totalVertices;
    private int K;
    private Vertex[] listofVertices;
    private int maxDist=0;

    public static void main(String[] args){
        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Clustering_SmallData.txt");
        ClusteringByRankCompression clusteringByRankCompression = new ClusteringByRankCompression();
        UnionFind unionFind = new UnionFind();
        clusteringByRankCompression.loadEdges(file, unionFind);
        Collections.sort(clusteringByRankCompression.edgeList, new Comparator<Edge>() {
            public int compare(Edge c1, Edge c2) {
                if (c1.weight < c2.weight) return -1;
                if (c1.weight > c2.weight) return 1;
                return 0;
            }} );

        clusteringByRankCompression.findCluster(unionFind);
        System.out.println("Maximum Cluster space is: " + clusteringByRankCompression.maxDist);
    }

    private void findCluster(UnionFind unionFind){
        for(Edge edge : edgeList){
            if(K < 5){
                if(unionFind.findSet(edge.u).value != unionFind.findSet(edge.v).value) {
                    if(edge.weight > maxDist)
                        maxDist = edge.weight;
                        return;
                }else continue;
            }
            if(unionFind.findSet(edge.u) != unionFind.findSet(edge.v)) {
                unionFind.Union(edge.u, edge.v);
                K--;
            }
        }
    }

    private void loadEdges(File file, UnionFind unionFind){
        try(Scanner scanner = new Scanner(file)){

            totalVertices = scanner.nextInt();
            listofVertices = new Vertex [totalVertices+1];
            K = totalVertices;
            while(scanner.hasNext()){
                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                int edgeCost = scanner.nextInt();

                if(listofVertices[src]==null) {
                    Vertex x = new Vertex(src);
                    listofVertices[src] = x;
                }
                if(listofVertices[dest]==null) {
                    Vertex y = new Vertex(dest);
                    listofVertices[dest] = y;
                }

                Edge edge = new Edge(listofVertices[src], listofVertices[dest], edgeCost);
                edgeList.add(edge);
                unionFind.makeSet(edge);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
