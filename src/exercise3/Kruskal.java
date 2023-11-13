package exercise3;
import java.util.*;
import exercise3.Edge;
import exercise3.Vertex;
import exercise3.EWGraph;

public class Kruskal {
  private List<Edge> minimumSpanningTree;
  private PriorityQueue<Edge> priorityQueue;
  private UnionFind unionFind;


  public Kruskal(EWGraph graph) {
    minimumSpanningTree = new ArrayList<Edge>();
    priorityQueue = new PriorityQueue<Edge>();
    unionFind = new UnionFind(graph.getNumVertices());

    for (Edge edge : graph.Edges()) { // run over all edges
      priorityQueue.add(edge);
    }

    while (!priorityQueue.isEmpty() && minimumSpanningTree.size() < graph.getNumVertices() - 1) {
      Edge edge = priorityQueue.poll();
      int v = edge.Either();
      int w = edge.Other(v);

      if (!unionFind.isConnected(v, w)) {
        unionFind.union(v, w);
        minimumSpanningTree.add(edge);
      }
    }
  }
  public List<Edge> getMinimumSpanningTree() {
    return minimumSpanningTree;
  }
  public double getWeight() {
    double weight = 0.0;
    for (Edge edge : minimumSpanningTree) {
      weight += edge.getWeight();
    }
    return weight;
  }
    public static void main(String[] args) {
        int numVertices = 8;
        EWGraph g = new EWGraph(numVertices);

        int[][] edgeList = {
            {0, 1, 7}, {0, 3, 6}, {0, 6, 9},
            {1, 2, 5}, {1, 3, 2}, {1, 4, 10},
            {2, 4, 4}, {2, 7, 13}, {3, 5, 1},
            {3, 6, 4}, {4, 5, 3}, {4, 7, 8},
            {5, 6, 14}, {5, 7, 16}, {6, 7, 2}
        };

        for (int[] e : edgeList) {
            g.addEdge(new Edge(e[0], e[1], e[2]));
        }

        Kruskal mst = new Kruskal(g);

        // Imprimir resultados
        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : mst.getMinimumSpanningTree()) {
            System.out.println(edge);
        }

        System.out.println("\nTotal Weight of Minimum Spanning Tree: " + mst.getWeight());
    }
}

