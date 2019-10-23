package jamal.contests;

public class MaximumNumberofBalloons5189 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoonloonbalxballpoon"));
    }

    static class Solution {
        public int maxNumberOfBalloons(String text) {
            if (text == null || text.length() == 0 || text.length() < "ballon".length()) {
                return 0;
            }
            int[] ch = new int[26];
            int total = 0;
            int result = 0;
            for (char c : text.toCharArray()) {
                int index = c - 'a';
                ch[index]++;
                total++;
            }
            while (total > 0) {
                for (char c : "balloon".toCharArray()) {
                    int index = c - 'a';
                    if (ch[index] > 0) {
                        ch[index]--;
                        total--;
                    } else {
                        return result;
                    }
                }
                result++;
            }
            return result;
        }
    }
}
