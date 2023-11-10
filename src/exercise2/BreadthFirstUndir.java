package exercise2;
import java.util.*;

import exercise1.UndirDirGraph3;
import exercise2.Vertex;


public class BreadthFirstUndir {
  protected UndirDirGraph3.UndirGraph graph;
  protected boolean[] marked;
  protected int[] edgeTo;
  protected int s; // initial vertex

  BreadthFirstUndir (UndirDirGraph3.UndirGraph graph, int s) {
    this.graph = graph;
    this.s = s;
    marked = new boolean[graph.getNumVertices()];
    edgeTo = new int[graph.getNumVertices()];
    Bfs(s);
  }

  void Bfs (int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    marked[v] = true;
    while (!queue.isEmpty()) {
      int w = queue.remove();
      Iterator<Integer> it = graph.getAdjIterator(w);
      while (it.hasNext()) {
        int x = it.next();
        if (!marked[x]) {
          queue.add(x);
          marked[x] = true;
          edgeTo[x] = w;
        }
      }
    }
  }
  boolean HasPathTo (int v) {
    return marked[v];
  }
  List<Integer> PathTo (int v) {
    if (!HasPathTo(v)) { // if there is no path to v
      return null;
    }
    int x = v;
    List<Integer> path = new ArrayList<>();
    while (x != s) {
      path.add(x);
      x = edgeTo[x];
    }
    path.add(s); // add the initial vertex
    return path;
    
  }
  
}
