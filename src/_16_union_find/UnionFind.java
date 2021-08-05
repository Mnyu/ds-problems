package _16_union_find;

/**
 * Given a set of N objects, 2 commands :
 * 1. Union command : connect 2 objects
 * 2. Is Connected A & B : is there a path connecting A & B --- internally uses Find
 * <p>
 * Implementation and its Amortized complexity :
 * If we have N objects, any sequence of M Union and Find operations will touch the array at most C(N + Mlog*N) times.
 * ==> Complexity : O(N + Mlog*N)
 * where log*N = No of times we have to take log of N to get 1
 * <p>
 * N        log*N
 * 1        0
 * 2        1
 * 4        2
 * 16       3
 * 65536    4
 * 2^65536  5
 * <p>
 * 2^65536 is a huge number and hence practically log*N <= 5
 *  ==> Practically, in real world the below algo runs in linear time [O(N + M)]
 */
public class UnionFind {
    private int[] parent;
    private byte[] rank;
    private int componentsCount;

    public UnionFind(int nodes) {
        parent = new int[nodes];
        rank = new byte[nodes];
        componentsCount = nodes;
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        validateNode(node);
        while (node != parent[node]) {
            parent[node] = parent[parent[node]]; // Path compression - practical optimization.
            node = parent[node];
        }
        return node;
    }

    public void union(int p, int q) {
        validateNode(p);
        validateNode(q);
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
        componentsCount--;
    }

    public boolean isConnected(int p, int q) {
        validateNode(p);
        validateNode(q);
        return find(p) == find(q);
    }

    public int getComponentsCount() {
        return componentsCount;
    }

    private void validateNode(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("Illegal node index");
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(4, 9);
        uf.union(3, 8);
        uf.union(5, 6);
        System.out.println("Components : " + uf.getComponentsCount());
        System.out.println("Is Connected 0 7 : " + uf.isConnected(0, 7));
        System.out.println("Is Connected 8 9 : " + uf.isConnected(8, 9));
        System.out.println("Is Connected 1 8 : " + uf.isConnected(8, 1));
        uf.union(2, 8);
        System.out.println("Components : " + uf.getComponentsCount());
        System.out.println("Is Connected 1 8 : " + uf.isConnected(8, 1));
    }
}
