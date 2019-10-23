package jamal;

import java.util.HashMap;
import java.util.Map;
public class FourKeysKeyboard {

    Map<Integer, Map<Integer, Map<Integer, Integer>>> cache = new HashMap();

    public static void main(String[] args) {
        FourKeysKeyboard fourKeysKeyboard = new FourKeysKeyboard();
        long start = System.currentTimeMillis();
        System.out.println(fourKeysKeyboard.maxA(50));
        System.out.println("Total time " + (System.currentTimeMillis() - start));
    }

    public int maxA(int N) {
        return rec(N, 0, 0);
    }

    public int rec(int n, int total, int buffer) {
        if (n == 0) {
            return total;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (cache.containsKey(n) && cache.get(n).containsKey(total) && cache.get(n).get(total).containsKey(buffer)) {
            return cache.get(n).get(total).get(buffer);
        }

        int print = rec(n - 1, total + 1, buffer);
        int ccv = rec(n - 3, total + total, total);
        int pb = rec(n - 1, total + buffer, buffer);
        int min = Math.max(print, Math.max(ccv, pb));
        cache.putIfAbsent(n, new HashMap());
        cache.get(n).putIfAbsent(total, new HashMap());
        cache.get(n).get(total).put(buffer, min);
        return min;
    }
}