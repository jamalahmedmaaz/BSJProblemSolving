package sagar;

class StringToInteger {
    public int myAtoi(String str) {
        int ans = 0, i = 0;
        int limit = -Integer.MAX_VALUE;
        boolean negative = false;
        int multMin = limit / 10;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i < str.length()) {
            if (str.charAt(i) == '-') {
                negative = true;
                i++;
            } else if (str.charAt(i) == '+') {
                i++;
            }
        }
        while (i < str.length()) {
            if (isNumercal(str.charAt(i))) {
                int digit = str.charAt(i) - '0';
                if (ans < multMin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans *= 10;
                if (ans < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans -= digit;
                i++;
            } else {
                break;
            }
        }
        return negative ? ans : -ans;
    }

    public static boolean isNumercal(char c) {
        return (c >= '0' && c <= '9');
    }
}
