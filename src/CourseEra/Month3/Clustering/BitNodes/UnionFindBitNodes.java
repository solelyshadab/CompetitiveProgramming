package CourseEra.Month3.Clustering.BitNodes;

public class UnionFindBitNodes {
    public void makeSet(Node node){
        node.parent = node;
        node.rank = 0;
    }

    public void Union(Node x, Node y){
        link(findSet(x),findSet(y));
    }

    public void link(Node x, Node y){
        if(x.rank > y.rank)
            y.parent = x;
        else
            x.parent = y;

        if(x.rank == y.rank)
            y.rank += 1;
    }

    public Node findSet(Node x){
        if(x != x.parent)
            x.parent = findSet(x.parent);
        return x.parent;
    }
}
