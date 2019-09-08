package jamal.array;

import java.util.*;

public class DeleteDistanceBetweenTwoString {

    public static void main(String[] args) {
        DeleteDistanceBetweenTwoString deleteDistanceBetweenTwoString =
                new DeleteDistanceBetweenTwoString();
        System.out.println(deleteDistanceBetweenTwoString.d("jamal", "mal"));
    }

    /**
     * PRAMP i am was the interviewer. SOLVE THIS PROBLEM.
     *
     * @param str1
     * @param str2
     * @return
     */

    public int d(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return 0;
        }
        int n = str1.length();
        int m = str2.length();
        return 1 + Math.min(d(str1.substring(0, n - 1), str2),
                d(str1, str2.substring(0, m - 1)));
    }


}




