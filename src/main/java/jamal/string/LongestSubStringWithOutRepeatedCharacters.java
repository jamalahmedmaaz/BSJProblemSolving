package jamal.string;

import java.util.HashSet;

public class LongestSubStringWithOutRepeatedCharacters {
    public static void main(String[] args) {
        LongestSubStringWithOutRepeatedCharacters longestSubStringWithOutRepeatedCharacters = new LongestSubStringWithOutRepeatedCharacters();
        System.out.println(longestSubStringWithOutRepeatedCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubStringWithOutRepeatedCharacters.lengthOfLongestSubstring("au"));
        System.out.println(longestSubStringWithOutRepeatedCharacters.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String string) {


        if (string == null || string.length() == 0) {
            return 0;
        }

        if (string.length() == 1) {
            return 1;
        }


        HashSet[] hashSets = new HashSet[string.length()];


        for (int i = 0; i < string.length(); i++) {
            hashSets[i] = new HashSet();
            hashSets[i].add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (hashSets[i].contains(string.charAt(j))) {
                    break;
                } else {
                    hashSets[i].add(string.charAt(j));
                }
            }
        }

        int counter = 0;

        for (int i1 = 0; i1 < hashSets.length; i1++) {
            if (counter < hashSets[i1].size()) {
                counter = hashSets[i1].size();
            }
        }


        return counter > 1 ? counter : 1;
    }

}
