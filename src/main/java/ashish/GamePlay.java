package ashish;

public class GamePlay {
    static int N = 100;
    static int[][] cache;
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        int k = 3;
        cache = new int[N + 1][k + 1];
        System.out.println(rec(1, k));
    }

    private static int rec(int total, int k) {
        if (total == N) {
            return 0;
        }
        if (total > N) {
            return Integer.MAX_VALUE / 2;
        }
        if (k <= 0 && total != N) {
            return Integer.MAX_VALUE / 2;
        }
        if (cache[total][k] != 0) {
            return cache[total][k];
        }
        int cs = Integer.MAX_VALUE;

        cs = Math.min(cs, 1 + rec(total + 1, k)) % mod;
        cs = Math.min(cs, 1 + rec(total + total, k - 1)) % mod;
        return cache[total][k] = cs;
    }

}
