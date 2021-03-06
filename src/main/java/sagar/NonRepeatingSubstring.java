package sagar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class NonRepeatingSubstring {
    //Sub Optimal
    public int lengthOfLongestSubstringUsingMap(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int maxLength = 0;
        int currLength = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                maxLength = Math.max(currLength, maxLength);
                char c = s.charAt(i);
                currLength = currLength - (map.get(c) - start);
                start = map.get(c) + 1;
                Set<Character> keySet = map.entrySet().stream().filter(entry -> entry.getValue() <= map.get(c)).map(entry -> entry.getKey()).collect(Collectors.toSet());
                map.keySet().removeAll(keySet);
                map.put(c, i);
            } else {
                map.put(s.charAt(i), i);
                currLength++;
            }
        }
        return Math.max(maxLength, currLength);
    }

    //Optimal
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int[] a = new int[256];
        for (int i = 0; i < 256; i++) {
            a[i] = -1;
        }
        int maxLength = 0;
        int currLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i)] == -1) {
                a[s.charAt(i)] = i;
                //System.out.println(a[i]);
                currLength++;
            } else {
                maxLength = Math.max(currLength, maxLength);
                currLength = currLength - (a[s.charAt(i)] - start);
                start = a[s.charAt(i)] + 1;
                for (int j = 0; j < 256; j++) {
                    if (a[j] != -1 && a[j] < a[s.charAt(i)]) {
                        a[j] = -1;
                    }
                }
                a[s.charAt(i)] = i;
            }
        }
        return Math.max(maxLength, currLength);
    }
}
