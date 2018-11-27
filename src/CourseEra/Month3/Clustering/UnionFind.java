package CourseEra.Month3.Clustering;

public class UnionFind {

    public void makeSet(Edge edge){
        edge.u.parent = edge.u;
        edge.u.rank = 0;

        edge.v.parent = edge.v;
        edge.v.rank = 0;
    }

    public void Union(Vertex x, Vertex y){
        link(findSet(x),findSet(y));
    }

    public void link(Vertex x, Vertex y){
    if(x.rank > y.rank)
        y.parent = x;
    else
        x.parent = y;

    if(x.rank == y.rank)
        y.rank += 1;
    }

    public Vertex findSet(Vertex x){
        if(x != x.parent)
            x.parent = findSet(x.parent);
        return x.parent;
    }

}
