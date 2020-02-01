package jamal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {

    int[] uf;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCostToSupplyWater(5, new int[]{46012, 72474, 64965, 751, 33304}, new int[][]{{2, 1, 6719}, {3, 2, 75312}, {5, 3, 44918}});
        s("abc");
    }

    public static void s(String str) {
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                int rightIndex = j + i;
                if (rightIndex > str.length()) {
                    continue;
                }
                System.out.println(str.substring(j, rightIndex));
            }
        }
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        uf = new int[n + 1];
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            uf[i + 1] = i + 1;
            edges.add(new int[]{0, i + 1, wells[i]});
        }
        for (int[] p : pipes) {
            edges.add(p);
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        System.out.println(Arrays.deepToString(edges.toArray()));
        int res = 0;
        for (int[] e : edges) {
            int x = find(e[0]), y = find(e[1]);
            if (x != y) {
                System.out.println(Arrays.toString(e));
                res += e[2];
                uf[x] = y;
            }
        }
        return res;
    }

    private int find(int x) {
        if (x != uf[x]) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}