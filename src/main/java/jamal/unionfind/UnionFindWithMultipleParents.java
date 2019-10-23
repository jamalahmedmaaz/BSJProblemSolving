package jamal.unionfind;

import java.util.HashSet;
import java.util.Set;
public class UnionFindWithMultipleParents {

    Set<Integer>[] uf;

    public UnionFindWithMultipleParents(int size) {
        uf = new HashSet[size];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = new HashSet<>();
            uf[i].add(i);
        }

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0}, {0, 2}, {2, 1}};
        UnionFindWithMultipleParents unionFindWithMultipleParents = new UnionFindWithMultipleParents(arr.length);
        for (int[] cell : arr) {
            System.out.println(unionFindWithMultipleParents.union(cell[1], cell[0]));
        }
    }

    public boolean union(int u, int v) {
        Set<Integer> i = find(u);
        Set<Integer> j = find(v);
        if (!i.contains(v)) {
            i.addAll(j);
        } else {
            return false;
        }
        return true;
    }

    public Set<Integer> find(int index) {
        if (!uf[index].contains(index)) {
            uf[index].addAll(find(index));
        }
        return uf[index];
    }
}
