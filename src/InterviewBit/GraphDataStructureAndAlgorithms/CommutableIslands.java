package InterviewBit.GraphDataStructureAndAlgorithms;
import java.util.*;
public class CommutableIslands {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // Will use Clustering by Rank Compression
        ArrayList<Edge> edgeList = new ArrayList<>();
        Vertex[] vertexArr = new Vertex[A+1];
        int ans = 0;

        for(int i = 0; i < B.size(); i++){

            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            int cost = B.get(i).get(2);

            if(vertexArr[u] == null){
                Vertex x = new Vertex(u);
                vertexArr[u] = x;
            }

            if(vertexArr[v] == null){
                Vertex y = new Vertex(v);
                vertexArr[v] = y;
            }

            Edge edge = new Edge(vertexArr[u], vertexArr[v], cost);
            edgeList.add(edge);
        }
        int K = A;
        Collections.sort(edgeList, Comparator.comparingInt(a -> a.cost));
        for(Edge edge : edgeList ){
            if(K < 1)
                break;

            if(find(edge.u) != find(edge.v)){
                Union(edge.u, edge.v);
                K--;
                ans += edge.cost;
            }

        }

        return ans;

    }

    private void Union(Vertex u, Vertex v){

        link(find(u), find(v));
    }

    private void link(Vertex u, Vertex v){
        if(u.rank > v.rank)
            v.parent = u;
        else
            u.parent = v;

        if(u.rank == v.rank)
            v.rank += 1;
    }

    private Vertex find(Vertex x){
        if(x != x.parent)
            x.parent = find(x.parent);

        return x.parent;
    }

    class Edge{
        Vertex u;
        Vertex v;
        int cost;

        public Edge(Vertex u, Vertex v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    class Vertex{
        Vertex parent;
        int rank;
        int value;

        public Vertex(int value){
            this.value = value;
            rank =0;
            parent = this;
        }
    }
}
