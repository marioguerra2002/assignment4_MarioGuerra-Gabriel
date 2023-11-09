package exercise1;
import java.util.*;
public class Vertex {
    int value;
    ArrayList<Integer> adj;

    Vertex(int value) {
        this.value = value;
        adj = new ArrayList<Integer>();
    }

    public int getValue() {
        return value;
    }
    public ArrayList<Integer> getAdj() {
        return adj;
    }
    public void addAdj(int v) {
        adj.add(v);
    }
    public void removeAdj(int v) {
        adj.remove((Integer) v);
    }
    public boolean hasAdj(int v) {
        if (adj.contains(v)) {
            return true;
        }
        return false;
    }
    public int getDegree() {
        return adj.size();
    }
}
