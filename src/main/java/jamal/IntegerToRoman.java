package jamal;

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(1));
        System.out.println(integerToRoman.intToRoman(3));
        System.out.println(integerToRoman.intToRoman(5));
        System.out.println(integerToRoman.intToRoman(7));
        System.out.println(integerToRoman.intToRoman(11));
        System.out.println(integerToRoman.intToRoman(13));
        System.out.println(integerToRoman.intToRoman(15));
        System.out.println(integerToRoman.intToRoman(58));
        System.out.println(integerToRoman.intToRoman(1007));
    }

    public String intToRoman(int num) {

        //In Roman Numbers the characters used are in the below sequence
        //    IVXLDCM


        //Any number given can be handled by taking number as 1's, 10's, 100's, 1000's

        //Example 1985 = onces digit is 5, ten's digit is 8, hundred's digit is 9, thousand digit is 1.

        // We prepare to represent this logic as below in roman form.


        // One's (DOESNT INCLUDE 10 CHECK, BECAUSE IT IS NOT IN 1's it 10 will be in 10's)
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        String M[] = {"", "M", "MM", "MMM"};


        //with the condition we need to find 4 different digit in the number and prepare the string.

        String ones = I[num % 10];
        String tens = X[(num % 100) / 10];
        String hundreds = C[(num % 1000) / 100];
        String thousand = M[num / 1000];

        return thousand + hundreds + tens + ones;

    }


}
