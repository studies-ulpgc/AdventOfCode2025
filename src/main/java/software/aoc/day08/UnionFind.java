package software.aoc.day08;

public class UnionFind {
    private final int[] parent;
    private final int[] size;
    private int subgraphs;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.subgraphs = n;
        union_find_definition(n);
    }

    private void union_find_definition(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean union(int a, int b) {
        if (find(a) == find(b)) return false;
        subgraphs--;
        calculate_union(find(a), find(b));
        return true;
    }

    private void calculate_union(int pa, int pb) {
        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    public int[] sizes() {
        return size;
    }

    public int subgraphs() {
        return subgraphs;
    }
}
