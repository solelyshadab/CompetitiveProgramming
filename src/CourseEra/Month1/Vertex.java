package CourseEra.Month1;


import java.io.*;
import java.util.*;

class Vertex{
    public int id;
    public ArrayList<Edge> neighbours;

    public Vertex(int id){
        this.id = id;
        neighbours = new ArrayList<Edge>();
    }
}
