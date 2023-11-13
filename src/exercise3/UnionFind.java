package exercise3;
import java.util.*;

public class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int N) {
        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public boolean isConnected(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    public void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if (rootA != rootB) {
            // Union by size: attach smaller tree to the root of the larger tree
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
    private int findRoot(int a) {
        while (a != parent[a]) {
            parent[a] = parent[parent[a]]; // Path compression
            a = parent[a];
        }
        return a;
    }
}

  


