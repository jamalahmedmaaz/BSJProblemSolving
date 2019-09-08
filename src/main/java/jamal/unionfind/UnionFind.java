package jamal.unionfind;

import java.util.Arrays;
public class UnionFind {
    int[] uf;

    public UnionFind(int capacity) {
        this.uf = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            uf[i] = i;
        }
    }

    public boolean union(int parent, int child) {
        int i = find(parent);
        int j = find(child);
        if (i != j) {
            uf[i] = j;
            return true;
        } else {
            return false;
        }
    }

    public int find(int index) {
        if (uf[index] != index) {
            uf[index] = find(uf[index]);
        }
        return uf[index];
    }

    public void print() {
        System.out.println();
        System.out.println("Union Find final Result: "+Arrays.toString(uf));
        System.out.println();
    }
}
