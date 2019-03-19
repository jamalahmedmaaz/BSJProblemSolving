package jamal;

public class PalindromeNumber {


    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(123));

        System.out.println(palindromeNumber.isPalindrome(-123));

        System.out.println(palindromeNumber.isPalindrome(1));
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(111131111));
        System.out.println(palindromeNumber.isPalindrome(-111131111));
    }

    public boolean isPalindrome(int number) {


        if (number == 0) {
            return true;
        }

        if (number < 0) {
            return false;
        }

        int x = number;

        int count = 0;
        boolean even = false;
        int tmpnumber = 0;
        while (x > 0) {
            x = x / 10;
            count++;
        }

        if (count % 2 == 0) {
            even = true;
        }

//         System.out.println(count);

        for (int i = 0; i < count / 2; i++) {

            if (tmpnumber == 0) {
                tmpnumber = (number % 10) + tmpnumber;
            } else {
                tmpnumber = (number % 10) + tmpnumber * 10;
            }


            number = number / 10;
        }

//         System.out.println(tmpnumber);

//         System.out.println(number);


        if (even) {
            return number == tmpnumber;
        } else {

            number = number / 10;

            return number == tmpnumber;
        }


    }
}
