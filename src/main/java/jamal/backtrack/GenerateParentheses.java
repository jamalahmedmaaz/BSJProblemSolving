package jamal.backtrack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.wordPattern("abba", "dog dog dog dog");
        List<String> result = new ArrayList<>();
        System.out.println(generateParentheses.generate(3, "", 0, 0, result));
    }

    private List<String> generate(int n, String currentString, int open,
                                  int close,
                                  List<String> result) {
        System.out.println(currentString);
        if (n * 2 == currentString.length()) {
            result.add(currentString);
            return result;
        }
        if (open < n) {
            generate(n, currentString + "(", open + 1, close, result);
        }
        System.out.println("-----------");
        if (close < open) {
            generate(n, currentString + ")", open, close + 1, result);
        }
        return result;
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> index = new HashMap();
        for (Integer i = 0; i < words.length; ++i) {
            Object a1 = index.put(pattern.charAt(i), i);
            Object a2 = index.put(words[i], i);
            if (a1 != a2)
                return false;
        }
        return true;
    }
}
