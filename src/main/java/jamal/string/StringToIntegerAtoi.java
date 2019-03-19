package jamal.string;

public class StringToIntegerAtoi {
    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);


        System.out.println(Integer.MAX_VALUE);

        StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();

        System.out.println(stringToIntegerAtoi.myAtoi(" "));
        System.out.println(stringToIntegerAtoi.myAtoi("42"));
        System.out.println(stringToIntegerAtoi.myAtoi("-42"));
        System.out.println(stringToIntegerAtoi.myAtoi("-42    "));
        System.out.println(stringToIntegerAtoi.myAtoi("    -454  "));

        System.out.println(stringToIntegerAtoi.myAtoi("    -65  jamal"));

        System.out.println(stringToIntegerAtoi.myAtoi(" jamal    -42  jamal"));

        System.out.println(stringToIntegerAtoi.myAtoi(" jamal    -42 "));


        System.out.println(stringToIntegerAtoi.myAtoi("-91283472332"));


        System.out.println(stringToIntegerAtoi.myAtoi("91283472332"));
        System.out.println(stringToIntegerAtoi.myAtoi("3.14159"));

        System.out.println(stringToIntegerAtoi.myAtoi("+1"));

    }

    public static boolean isNumercal(char c) {
        return (c >= '0' && c <= '9');
    }

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
}
