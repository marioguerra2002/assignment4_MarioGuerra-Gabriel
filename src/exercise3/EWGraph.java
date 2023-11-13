package exercise3;
import java.lang.reflect.Array;
import java.util.*;
import exercise3.Vertex;
import exercise3.Edge;
public class EWGraph {
    protected int V; // numero de vertices
    protected int E = 0; // numero de edges
    protected ArrayList<Vertex> adj; // lista de adyacencia

    // constructor
    EWGraph(int v) {
        V = v;
        adj = new ArrayList<Vertex>();
        for (int i = 0; i < v; ++i) {
            adj.add(new Vertex(i));
        }
    }
    EWGraph() {
        V = 0;
        adj = new ArrayList<Vertex>();
    }
    
    public ArrayList<Vertex> getAdj() { // get the list of all vertices
        return adj;
    }

    public int getNumVertices() {
        return V;
    }

    public int getNumEdges() {
        return E;
    }
    public List<Edge> Adj(int v) {  // get the list of adjacent vertices of a precise vertex
        return adj.get(v).getAdj();
    }
    public List<Edge> Edges() { // get the list of all edges
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            edges.addAll(adj.get(i).getAdj());
        }
        return edges;
    }
    
    // se tratan de grafos no dirigidos por lo que se añade la arista en ambos sentidos
    public void addEdge(Edge e) {
        int v = e.Either();
        int w = e.Other(v);
        adj.get(v).addAdj(w); // añadimos la arista en ambos sentidos
        adj.get(w).addAdj(v);
        E++;
    }
    
    public Iterator<Integer> getVIterator() {
        List<Integer> vertex = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            vertex.add(i);
        }
        return vertex.iterator();
    }
    
    
    
}