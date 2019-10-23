package jamal;

public class StoneGame {

    private static final int[] A = null;

    public static void main(String[] args) {
        int j = 0;
        int left = j - 1 >= 0 ? A[j - 1] : Integer.MAX_VALUE;
        StoneGame stoneGame = new StoneGame();
        System.out.println(stoneGame.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }

    public int stoneGameII(int[] piles) {
        int total = game(piles, true, 0, 1);
        return total;
    }

    public int game(int[] A, boolean isAlex, int i, int M) {
        if (i >= A.length) {
            return 0;
        }
        int totalF = addNumber(i, i + M, A);

        if (isAlex) {
            int alexTotalF = totalF + game(A, false, i + M, 2 * M);
            return alexTotalF;
        } else {
            int leeTotalF = totalF + game(A, true, i + M, 2 * M);
            return leeTotalF;
        }
    }

    public int addNumber(int start, int end, int[] A) {
        if (start < 0) {
            start = 0;
        }

        int total = 0;
        for (; start < end && start < A.length; start++) {
            total += A[start];
        }
        return total;
    }

}