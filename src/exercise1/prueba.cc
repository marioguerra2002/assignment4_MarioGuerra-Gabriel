#include <iostream>
#include <vector>
#include <map>
#include <iterator>

class Grafo {
  private: 
    std::map<int, std::vector<int>> adj;
    int n; // número de nodos
    int e; // número de aristas
  public:
    Grafo(int n);
    int getNumVertices() { return n; };
    int getNumEdges() { return e; };
    std::vector<int> getAdj(int v) { return adj[v]; };
    int getDegree(int v) { return adj[v].size(); };
    int getMaxDegree();
    bool hasEdge(int v, int w);
    void addEdge(int v, int w);
    void removeEdge(int v, int w);

    // // iteradores para el vector que recorren los adyacentes de un nodo
    // std::vector<int>::iterator getAdjBegin(int v) { return adj[v].begin(); };
    // std::vector<int>::iterator getAdjEnd(int v) { return adj[v].end(); };
    // // iteradores para el map que recorren los nodos
    // std::map<int, std::vector<int>>::iterator getBegin() { return adj.begin(); };
    // std::map<int, std::vector<int>>::iterator getEnd() { return adj.end(); };

    void print();
};

Grafo::Grafo(int n) {
  this->n = n;
  this->e = 0;
  for (int i = 0; i < n; i++) {
    std::vector<int> v;
    adj[i] = v;
  }
}

int Grafo::getMaxDegree() {
  int max = 0;
  for (int i = 0; i < n; i++) {
    if (adj[i].size() > max) {
      max = adj[i].size();
    }
  }
  return max;
}

void Grafo::addEdge(int v, int w) {
  adj[v].push_back(w);
  adj[w].push_back(v);
  e++;
}

bool Grafo::hasEdge(int v, int w) {
  for (int i = 0; i < adj[v].size(); i++) {
    if (adj[v][i] == w) {
      return true;
    }
  }
  return false;
}
// en caso de que sean grafos no dirigidos ( si fueran dirigidos habría que eliminar solo una de las dos aristas)
void Grafo::removeEdge(int v, int w) {
  for (int i = 0; i < adj[v].size(); i++) {
    if (adj[v][i] == w) {
      adj[v].erase(adj[v].begin() + i);
    }
  }
  for (int i = 0; i < adj[w].size(); i++) {
    if (adj[w][i] == v) {
      adj[w].erase(adj[w].begin() + i);
    }
  }
}
void Grafo::print() {
  for (int i = 0; i < n; i++) {
    std::cout << i << ": ";
    for (int j = 0; j < adj[i].size(); j++) {
      std::cout << adj[i][j] << " ";
    }
    std::cout << std::endl;
  }
}


int main() {
  Grafo g(11);
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
  g.print();
  std::cout << "Max degree: " << g.getMaxDegree() << std::endl;
  std::cout << "Has edge 0-2: " << g.hasEdge(0, 2) << std::endl;
  
  g.removeEdge(0, 2);
  std::cout << "Has edge 0-2: " << g.hasEdge(0, 2) << std::endl;
  g.print();
  return 0;
}