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

    public int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }


        str = str.trim();

        boolean negative = str.length() > 0 && str.charAt(0) == '-';

        int number = 0;
        int multiplier = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case '.':

                    multiplier = 1;
                    number = 0;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    int current = (int) str.charAt(i) - '0';
                    if (current >= 0 && current <= 9) {

                        number = multiplier * current + number;
                        long l = ((long) multiplier * current) + (long) number;

                        if (l > Integer.MAX_VALUE)
                            if (negative)
                                number = Integer.MIN_VALUE;
                            else
                                number = Integer.MAX_VALUE;

                        if (negative && l < Integer.MIN_VALUE)
                            number = Integer.MIN_VALUE;


                        multiplier = multiplier * 10;
                    }
                    break;
                case '-':
                    number = -number;
                    break;
                default:
                    if (str.charAt(i) == '+') {
                        break;
                    }
                    if (str.charAt(i) != ' ') {
                        number = 0;
                    }

            }

        }


        return number;
    }
}
