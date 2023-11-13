package exercise3;
import java.util.*;
import exercise3.Edge;
public class Vertex {
    int value;
    ArrayList<Edge> adj;

    Vertex(int value) {
        this.value = value;
        adj = new ArrayList<Edge>();
    }
    public int getValue() {
        return value;
    }
    public ArrayList<Edge> getAdj() {
        return adj;
    }
    public void addAdj(int v) {
      Edge auxiliar = new Edge(value, v, 1.0);
      if (!adj.contains(auxiliar)) {
        adj.add(new Edge(value, v, 1.0));
      }
    }
    public void addAdj(int v, double weight) {
      Edge auxiliar = new Edge(value, v, weight);
      if (!adj.contains(auxiliar)) {
        adj.add(new Edge(value, v, weight));
      }
    }
    public void removeAdj(int v) {
        adj.remove(v);
    }
    public boolean hasAdj(int v) {
      Edge auxiliar = new Edge(value, v, 1.0);
      for (Edge e : adj) {
        if (e.Equals(auxiliar)) {
          return true;
        }
      }
      return false;
    }
    public int getDegree() {
        return adj.size();
    }
}
