package jamal.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Tiles {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities("AAB", 0));
    }

    static class Solution {
        Set<String> result = new HashSet();
        List<Character> tmp = new ArrayList();

        public int numTilePossibilities(String tiles, int i) {
            permutation(tiles.toCharArray(), i);
            return result.size();
        }

        public void permutation(char[] ch, int index) {
            result.add(createString());
            for (int i = index; i < ch.length; i++) {
                tmp.add(ch[i]);
                permutation(ch, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }

        public String createString() {
            StringBuilder sb = new StringBuilder();
            for (char c : tmp) {
                sb.append(c);
            }
            return sb.toString();
        }
    }

}
