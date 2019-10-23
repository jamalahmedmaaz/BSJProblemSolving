package jamal.Mocks;

import java.util.HashSet;
import java.util.Set;
public class UniqueEmails {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numUniqueEmails(new String[]{"testemail+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    static class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet();
            for (String email : emails) {
                String[] split = email.split("@");
                if (split.length == 2) {
//                    System.out.println(Arrays.toString(split));

                    String epart = split[0].replace(".", "");

                    if (epart.indexOf("+") >= 0) {
                        epart = epart.substring(0, epart
                                .indexOf("+"));
                    }
//                    System.out.println(epart);
                    String newE = epart + "@" + split[1];
                    set.add(newE);
                }
            }
            return set.size();
        }
    }
}
