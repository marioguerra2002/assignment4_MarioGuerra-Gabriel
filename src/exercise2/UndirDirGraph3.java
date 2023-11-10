package exercise2;
import java.lang.reflect.Array;
import java.util.*;
import exercise2.Vertex;

import exercise2.BreadthFirstDir;
import exercise2.DepthFirstDir;

import exercise2.BreadthFirstUndir;
import exercise2.DepthFirstUndir;

public class UndirDirGraph3 {
    protected int V; // numero de vertices
    protected int E = 0; // numero de edges
    protected ArrayList<Vertex> adj; // lista de adyacencia

    // constructor
    UndirDirGraph3(int v) {
        V = v;
        adj = new ArrayList<Vertex>();
        for (int i = 0; i < v; ++i) {
            adj.add(new Vertex(i));
        }
    }

    UndirDirGraph3() {
        V = 0;
        adj = new ArrayList<Vertex>();
    }

    public ArrayList<Vertex> getAdj() {
        return adj;
    }

    public int getNumVertices() {
        return V;
    }

    public int getNumEdges() {
        return E;
    }

    public Vertex getVertex(int v) {
        return adj.get(v);
    }

    public void addEdge(int v, int w) {
        adj.get(v).addAdj(w);
        E++;
    }
    public Iterator<Integer> getAdjIterator(int v) {
        return adj.get(v).getAdj().iterator();
    }
    public Iterator<Integer> getVIterator() {
        
        List<Integer> vertex = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            vertex.add(i);
        }
        return vertex.iterator();
    }
    public Iterator<Integer> getEIterator() {
        List<Integer> edges = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < adj.get(i).getDegree(); ++j) {
                edges.add(i);
                edges.add(adj.get(i).getAdj().get(j)); 
            }
        }
        return edges.iterator();
    }

    public class DirGraph extends UndirDirGraph3 {
        DirGraph(int v) {
            super(v);
        }

        public void addEdge(int v, int w) {
            adj.get(v).addAdj(w); // agregar arco v->w
            E++;
        }

        public void removeEdge(int v, int w) {
            adj.get(v).removeAdj(w); // remover arco v->w. (Integer) para que no se confunda con el indice
            E--;
        }
        
    }

    public class UndirGraph extends UndirDirGraph3 {
        public UndirGraph(int v) {
            super(v);
        }

        @Override
        public void addEdge(int v, int w) {
            adj.get(v).addAdj(w); // agregar arco v->w
            adj.get(w).addAdj(v); // agregar arco w->v
            E++;
        }

        public void removeEdge(int v, int w) {
            adj.get(v).removeAdj(w); // remover arco v->w. (Integer) para que no se confunda con el indice
            adj.get(w).removeAdj(v); // remover arco w->v. (Integer) para que no se confunda con el indice
            E--;
        }
    }
    public static void main (String[] args) {
      UndirDirGraph3 f = new UndirDirGraph3(11);
      UndirDirGraph3.UndirGraph g = f.new UndirGraph(11);

      // for (int i = 0; i < 5; i++) {
      //   System.out.println(g.getAdj().get(i).getValue());
      // }
      // System.out.println();
      // // g.getAdj().get(0).addAdj(2);
      // // if (g.getAdj().get(0).hasAdj(2)) {
      // //   System.out.println("0 has 2");
      // // }
      for (int i = 0; i < 3; i++) {
          System.out.println(g.getVertex(i).getValue());
      }
      ;
      g.addEdge(0, 2);
      System.out.println(g.getNumEdges());
      if (g.getAdj().get(0).hasAdj(2)) {
          System.out.println("0 has 2");
      } else {
          System.out.println("0 does not have 2");
      }
    DepthFirstUndir h = f.new DepthFirstUndir(g, 0);
          
  }
}