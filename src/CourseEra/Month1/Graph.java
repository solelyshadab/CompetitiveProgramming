package CourseEra.Month1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    private Hashtable<Integer, Vertex> vertices;
    private ArrayList<Edge> edges;
    private String inputFileName;

    public Graph(String inputFileName) throws FileNotFoundException {
        this.inputFileName = inputFileName;
        vertices = new Hashtable<Integer, Vertex>();
        edges = new ArrayList<Edge>();
        Scanner in = new Scanner(new File(inputFileName));
        //add all vertices
        while (in.hasNextLine()){
            Scanner line = new Scanner(in.nextLine());
            int id = line.nextInt();
            Vertex v = new Vertex(id);
            vertices.put(id, v);
        }
        in = new Scanner(new File(inputFileName));
        //add edges
        while (in.hasNextLine()){
            Scanner line = new Scanner(in.nextLine());
            int idU = line.nextInt();
            Vertex u = vertices.get(idU);
            while (line.hasNextInt()){
                int idV = line.nextInt();
                Vertex v = vertices.get(idV);
                if (u.id < v.id){
                    addEdge(u, v, 1);
                }
            }
        }
    }

    public void addEdge(Vertex u, Vertex v, int count){
        int idU = u.id;
        int idV = v.id;
        Edge e = new Edge(vertices.get(Math.min(idU, idV)), vertices.get(Math.max(idU, idV)));
        for (int i = 0; i < count; i++){
            vertices.get(idU).neighbours.add(e);
            vertices.get(idV).neighbours.add(e);
            edges.add(e);
        }
    }

    public int removeEdge(Vertex u, Vertex v){
        int count = 0;
        int idU = u.id;
        int idV = v.id;
        Edge e = new Edge(vertices.get(Math.min(idU, idV)), vertices.get(Math.max(idU, idV)));
        for (int i = 0; i < u.neighbours.size(); i++){
            if (u.neighbours.get(i).isSame(e)){
                u.neighbours.remove(i);
                i--;
            }
        }
        for (int i = 0; i < v.neighbours.size(); i++){
            if (v.neighbours.get(i).isSame(e)){
                v.neighbours.remove(i);
                i--;
            }
        }
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i).isSame(e)){
                edges.remove(i);
                i--;
                count++;
            }
        }
        return count;
    }

    public void randomContract(){
        Random generator = new Random();
        while (vertices.size() > 2){
            int index = generator.nextInt(edges.size());
            Edge toRemove = edges.get(index);
            int idV = toRemove.v.id;
            Vertex u = toRemove.u;
            Vertex v = toRemove.v;
            removeEdge(u, v);
            while (v.neighbours.size() > 0){
                Vertex w = v.neighbours.get(0).getAnother(v);
                addEdge(u, w, removeEdge(v, w));
            }
            vertices.remove(idV);
        }
    }

    public void printGraph(){
        System.out.println("vertices:");
        Enumeration<Integer> enumKey = vertices.keys();
        while (enumKey.hasMoreElements()){
            Integer id = enumKey.nextElement();
            System.out.print(id + ": ");
            for (Edge e : vertices.get(id).neighbours){
                System.out.print(e.u.id + "-" + e.v.id + " ");
            }
            System.out.println();
        }
        System.out.println("edges:");
        for (Edge e : edges){
            System.out.print(e.u.id + "-" + e.v.id + " ");
        }
        System.out.println();
    }

    public int findMinCut() throws FileNotFoundException{
        int n = vertices.size();
        int minCut = n;
        //WARNING: Please change the value of nRepeat to a much smaller one (e.g. n)
        //if you want the program run faster! However, n^2 * ln(n) times of repeat
        //would ensure a (1-1/n) rate of success on finding the minCut.
        //int nRepeat = (int) (Math.pow(n, 2) * Math.log(n)); //Please read Warning above!
        int nRepeat = n; //You can change to this one.
        for (int i = 0; i < nRepeat; i++){
            Graph g = new Graph(this.inputFileName);
            g.randomContract();
            int crossingEdges = g.edges.size();
            if (crossingEdges < minCut){
                minCut = crossingEdges;
            }
        }
        return minCut;
    }

    public static void main(String[] args) throws FileNotFoundException{
        //Graph g = new Graph("SimpleInput.txt");
        Graph g = new Graph("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/MinCut_GraphData.txt");
        System.out.println(g.findMinCut());
        //g.printGraph();
    }
}

