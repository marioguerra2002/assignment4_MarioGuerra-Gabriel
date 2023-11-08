// implementar indirecto y directo grafos usando listas de adyacencia
package exercise1;
import java.util.*;

public class UndirDirGraph {
    private int V; // numero de vertices
    private int E = 0; // numero de edges
    private Map<Integer, List<Integer>> adj = new HashMap<>(); // lista de adyacencia

    // constructor
    UndirDirGraph(int v) {
        V = v;
        adj = new HashMap<>();
        for (int i=0; i < v; ++i) {
        	adj.put(i, new ArrayList<>()); // inicializar listas de adyacencia (cada vertice tiene una lista de adyacencia)
    	}
	}
    UndirDirGraph() {
        V = 0;
        adj = new HashMap<Integer, List<Integer>>();
    }
    public int getNumVertices() {
        return V;
    }
    public int getNumEdges() {
        return E;
    }
    public List<Integer> getAdj(int v) {
        return adj.get(v); // retorna la lista de adyacencia del vertice v
    }
    public int getDegree(int v) {
        return adj.get(v).size(); // retorna el grado del vertice v (degree es el numero de vertices adyacentes)
    }
    /////// estos metodos se implementaran individualmente en las clases UndirGraph y DirGraph
    // public void addEdge(int v, int w) {
    //     adj.get(v).add(w); // agregar arco v->w
    //     E++;
    // }
    // public void removeEdge(int v, int w) {
    //     adj.get(v).remove((Integer) w); // remover arco v->w. (Integer) para que no se confunda con el indice
    //     E--;
    // }
    public boolean hasEdge (int v, int w) {
        if (adj.get(v).contains(w)) {
            return true;
        }
        return false;
    }
    public Iterator<Integer> getAdjIterator(int v) {
        return adj.get(v).iterator(); // retorna un iterador de los vertices adyacentes al vertice v
    }
    public Iterator<Integer> getVIterator() {
        return adj.keySet().iterator(); // retorna un iterador de los vertices
    }
    public Iterator<Integer> getEIterator() {
        List<Integer> edges = new ArrayList<>();
        for (int i=0; i < V; ++i) {
            for (int j=0; j < getDegree(i); ++j) {
                if (i > getAdj(i).get(j)) continue; // para no repetir los edges (en el caso de grafos indirectos)
                edges.add(i); // agregar el vertice i
                edges.add(getAdj(i).get(j)); // agregar el vertice adyacente al vertice i
            }
        }
        return edges.iterator(); // retorna un iterador de los todos los edges
    }
    public int getMaxDegree() { // retorna el grado maximo
        int maxDegree = 0;
        for (int i=0; i<V; ++i) {
            if (getDegree(i) > maxDegree) {
                maxDegree = getDegree(i);
            }
        }
        return maxDegree;
    }
    class UndirGraph extends UndirDirGraph {
        public UndirGraph(int v) {
            super(v);
        }
        public void addEdge(int v, int w, double weight) {
            adj.get(v).add(w); // agregar arco v->w
            adj.get(w).add(v); // agregar arco w->v
            E++;
        }
        public void addEdge(int v, int w) {
            addEdge(v, w, 1.0); // agregar arco v->w con peso 1.0 (por defecto)
        }
        public void removeEdge(int v, int w) {
            adj.get(v).remove((Integer) w); // remover arco v->w. (Integer) para que no se confunda con el indice
            adj.get(w).remove((Integer) v); // remover arco w->v
            E--;
        }
    }
    // importante destacar que add es unilateral, es decir, solo se agrega el arco v->w, no w->v como en el caso de grafos indirectos
    class DirGraph extends UndirDirGraph {
        public DirGraph(int v) {
            super(v);
        }
        public void addEdge(int v, int w, double weight) {
            adj.get(v).add(w); // agregar arco v->w 
            E++;
        }
        public void addEdge(int v, int w) {
            addEdge(v, w, 1.0); // agregar arco v->w con peso 1.0 (por defecto)
        }
        public void removeEdge(int v, int w) {
            adj.get(v).remove((Integer) w); // remover arco v->w. (Integer) para que no se confunda con el indice
            E--;
        }
    }
    public static void main(String[] args) {
        // UndirDirGraph g = new UndirDirGraph(12);
        UndirDirGraph f = new UndirDirGraph(11);
        UndirGraph g = f.new UndirGraph(11);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 10);
        g.addEdge(10, 6);      
        
    }
}






                