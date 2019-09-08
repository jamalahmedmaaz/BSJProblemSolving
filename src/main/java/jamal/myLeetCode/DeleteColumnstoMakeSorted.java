package jamal.myLeetCode;

public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        if (A == null) return 0;
        int ret = 0;
        int numCols = A[0].toCharArray().length;
        for (int i = 0; i < numCols; i++) {
            if (!colIsOrdered(A, i)) ret++;
        }

        return ret;
    }

    public static boolean colIsOrdered(String[] A, int col) {
        char prev = A[0].charAt(col);
        for (int i = 0; i < A.length; i++) {
            if (A[i].charAt(col) < prev) {
                return false;
            }
            prev = A[i].charAt(col);
        }
        return true;
    }
}
