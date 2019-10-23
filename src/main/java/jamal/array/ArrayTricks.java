package jamal.array;

import java.util.HashSet;
import java.util.Set;
public class ArrayTricks {

    public static void main(String[] args) {
        ArrayTricks arrayTricks = new ArrayTricks();
        arrayTricks.checkBoundariesAreSame(new int[][]{{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 2, 2, 1}, {1, 1, 1, 1}});
    }

    public void checkBoundariesAreSame(int[][] array) {
        int r = array.length;
        int c = array.length;
        Set<Integer> set = new HashSet<>();
        for (int count = 0; count < 2; count++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == count || j == count || i == r - count - 1 || j == c - count - 1) {
                        if (set.isEmpty()) {
                            set.add(array[i][j]);
                        } else if (!set.contains(array[i][j])) {
                            System.out.println("Boundaries are not same");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Boundaries are same");
    }

}
