package jamal.subsequence;

public class SubSequence {

    public static void main(String[] args) {
        SubSequence subsequence = new SubSequence();
        subsequence.subSequence("abc", "", 0);
        System.out.println(" ---------------------------- ");
        subsequence.subSequence2("abc", "", 0);
        System.out.println(" ---------------------------- ");
        subsequence.subSequence3("abc", "", 0, 3);
    }

    public void subSequence(String string, String tmp, int i) {
        if (i > string.length()) {
            return;
        }
        if (!tmp.equals("")) {
            System.out.println(tmp);
        }

        /*for (int i = index; i < string.length(); i++) {
            tmp = tmp + string.charAt(i);
            subSequence(string, tmp, i + 1);
            tmp = tmp.substring(0, tmp.length() - 1);
        }*/

        if (i < string.length()) {
            subSequence(string, tmp + string.charAt(i), i + 1);
        }
        if (tmp.length() > 0) {
            subSequence(string, tmp.substring(0, tmp.length() - 1), i);
        }
    }

    public void subSequence2(String string, String tmp, int index) {

        System.out.println(tmp);
        for (int i = index; i < string.length(); i++) {
            tmp = tmp + string.charAt(i);
            subSequence(string, tmp, i + 1);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }

    public void subSequence3(String string, String tmp, int i, int j) {
        if (i > j) {
            return;
        }

        System.out.println(tmp);
//        System.out.println(string.substring(i, j));

//        subSequence3(string, "", i + 1, j - 1);
        subSequence3(string, tmp + " " + i, i + 1, j);
        subSequence3(string, tmp.substring(0, tmp.length() - 1), i, j - 1);
    }

}
