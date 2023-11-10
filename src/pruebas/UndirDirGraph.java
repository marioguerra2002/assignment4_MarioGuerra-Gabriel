// implementar indirecto y directo grafos usando listas de adyacencia
package pruebas;
import java.util.*;

public class UndirDirGraph {
    private int V; // numero de vertices
    private int E = 0; // numero de edges
    private ArrayList<ArrayList<Integer>> adj; // lista de adyacencia

    // constructor
    UndirDirGraph(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i=0; i < v; ++i) {
            adj.add(new ArrayList<Integer>());
            adj.get(i).add(i); // agregar el vertice i a la lista de adyacencia (la posicion 0 de cada lista es el vertice)
    	}
	}
    UndirDirGraph() {
        V = 0;
        adj = new ArrayList<ArrayList<Integer>>();
    }
    public int getNumVertices() {
        return V;
    }
    public int getNumEdges() {
        return E;
    }
    public List<Integer> getAdj(int v) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < adj.get(getVertexListPosition(v)).size(); i++) {
            list.add(adj.get(getVertexListPosition(v)).get(i)); // agregar el adyacente a la lista
        }
        return list; // retorna la lista de adyacencia del vertice v
    }
       
    public int getDegree(int v) {
        return adj.get(getVertexListPosition(v)).size() - 1; 
        // retorna el grado del vertice v (degree es el numero de vertices adyacentes -1 porque el primer elemento es el vertice)
    }
    public boolean hasEdge (int v, int w) {
        for (int j = 1; j < adj.get(getVertexListPosition(v)).size(); j++) { // recorremos la lista de adyacencia
            if (adj.get(getVertexListPosition(v)).get(j) == w) return true; // si encontramos el adyacente
        }
        return false; // si no se encuentra el adyacente
       
    }
    public Integer getVertexListPosition (int v) {
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).get(0) == v) { // si es el vérice que buscamos
                return i; // retornamos la posicion del vertice en la lista de adyacencia
            }
        }
        return null; // si no se encuentra el vertice
    }
    public Iterator<Integer> getAdjIterator(int v) {
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).get(0) == v) { // si es el vérice que buscamos
                return adj.get(i).iterator(); // retornamos el iterador de la lista de adyacencia
            }
        }
        return null; // si no se encuentra el vertice
    }
    public Iterator<Integer> getVIterator() {
        List<Integer> vertices = new ArrayList<>();
        for (int i=0; i < V; ++i) {
            vertices.add(i); // agregar el vertice i
        }
        return vertices.iterator(); // retorna un iterador de los todos los vertices
    }
    public Iterator<Integer> getEIterator() {
        List<Integer> edges = new ArrayList<>();
        for (int i=0; i < V; ++i) {
            for (int j=1; j < adj.get(i).size(); ++j) {
                edges.add(adj.get(i).get(j)); // agregar el arco i->j
            }
        }
        return edges.iterator(); // retorna un iterador de los todos los arcos        
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
            adj.get(getVertexListPosition(v)).add(w); // agregar arco v->w
            adj.get(getVertexListPosition(w)).add(v); // agregar arco w->v
            E++;
        }
        public void addEdge(int v, int w) {
            addEdge(v, w, 1.0); // agregar arco v->w con peso 1.0 (por defecto)
        }
        public void removeEdge(int v, int w) {
            adj.get(getVertexListPosition(v)).remove((Integer) w); // remover arco v->w
            adj.get(getVertexListPosition(w)).remove((Integer) v); // remover arco w->v
            E--;
        }
    }
    // importante destacar que add es unilateral, es decir, solo se agrega el arco v->w, no w->v como en el caso de grafos indirectos
    class DirGraph extends UndirDirGraph {
        public DirGraph(int v) {
            super(v);
        }
        public void addEdge(int v, int w, double weight) {
            adj.get(getVertexListPosition(v)).add(w); // agregar arco v->w 
            E++;
        }
        public void addEdge(int v, int w) {
            addEdge(v, w, 1.0); // agregar arco v->w con peso 1.0 (por defecto)
        }
        public void removeEdge(int v, int w) {
            adj.get(getVertexListPosition(v)).remove((Integer) w); // remover arco v->w. (Integer) para que no se confunda con el indice
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






                