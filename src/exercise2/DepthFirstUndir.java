package exercise2;
import java.util.*;

import exercise1.UndirDirGraph3;
import exercise2.Vertex;

public class DepthFirstUndir {
  protected UndirDirGraph3.UndirGraph graph;
  protected boolean[] marked;
  protected int[] edgeTo;
  protected int s; // initial vertex

  DepthFirstUndir (UndirDirGraph3.UndirGraph graph, int s) {
    this.graph = graph;
    this.s = s;
    marked = new boolean[graph.getNumVertices()];
    edgeTo = new int[graph.getNumVertices()];
    Dfs(s);
  }

  void Dfs (int v) {
    marked[v] = true;
    Iterator<Integer> it = graph.getAdjIterator(v);
    while (it.hasNext()) {
      int w = it.next();
      if (!marked[w]) {
        edgeTo[w] = v;
        Dfs(w);
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