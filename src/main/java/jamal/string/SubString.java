package jamal.string;

import java.util.Arrays;
public class SubString {
    public static void main(String[] args) {
        System.out.println(null == null);
        System.out.println(Integer.MAX_VALUE);
        String string = "babad";
        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                int rightIndex = j + i;
                if (rightIndex > string.length()) {
                    continue;
                }
                System.out.println(string.substring(j, rightIndex));
            }
        }

        SubString subString = new SubString();
        subString.longestPalindromicSubString(string);
        System.out.println(subString.count8(8088));
        System.out.println(subString.countHi("xxhixx"));
        System.out.println("abcd".substring(0, 1));
        System.out.println(2 % 1);
    }

    public int count8(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;

        int tmp = n % 10;
        if (tmp == 8) {
            count++;
            n = n / 10;
            if (n % 10 == 8) {
                count = count + 2;
            }
        }

        return count + count8(n / 10);
    }

    public int countHi(String str) {
        if (str.length() < 2) {
            return 0;
        }

        String s = str.substring(0, 2);

        if (s == "hi") {
            return 1 + countHi(str.substring(2, str.length()));
        } else {
            return countHi(str.substring(1, str.length()));
        }
    }

    public String longestPalindromicSubString(String string) {
        boolean[][] dp = new boolean[string.length()][string.length()];
        String res = null;
        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                int right = j + i;
                if (right > string.length()) {
                    continue;
                }
                int rightIndex = right - 1;
                int leftIndex = j;

                dp[leftIndex][rightIndex] = string.charAt(leftIndex) == string.charAt(rightIndex) &&
                        (rightIndex - leftIndex < 3 || dp[leftIndex + 1][right - 1]);

                if (dp[leftIndex][rightIndex]) {
                    res = string.substring(leftIndex, rightIndex + 1);
                }

            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(res);
        return res;
    }

    private boolean isPalindrome(String substring) {
        if (substring != null && substring.length() == 1) {
            return true;
        }
        return false;
    }

}