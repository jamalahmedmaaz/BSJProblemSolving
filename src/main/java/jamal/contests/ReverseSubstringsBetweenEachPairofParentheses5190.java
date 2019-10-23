package jamal.contests;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
public class ReverseSubstringsBetweenEachPairofParentheses5190 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses("sxmdll(q)eki(x)"));
    }

    static class Solution {
        public String reverseParentheses(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            char ch[] = s.toCharArray();
            Deque<Integer> dq = new LinkedList();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '(') {
                    dq.add(i);
                } else if (ch[i] == ')') {
                    dq.add(i);
                }
            }
//            System.out.println(Arrays.toString(dq.toArray()));
            int x = dq.size() / 2;
            Stack<Integer> front = new Stack();
            for (int i = 0; i < x; i++) {
                front.add(dq.poll());
            }

            Stack<Integer> send = new Stack();
            for (int i = 0; i < x; i++) {
                send.add(dq.poll());
            }

            while (!front.isEmpty()) {
                dq.add(front.pop());
            }

            while (!send.isEmpty()) {
                dq.addLast(send.pop());
            }

//            System.out.println(Arrays.toString(dq.toArray()));
            if (dq.isEmpty()) {
                return s;
            }
            while (!dq.isEmpty()) {
                int start = dq.pollFirst();
                int end = dq.pollLast();
                reverse(start, end, ch);
            }

            StringBuilder sb = new StringBuilder();

            for (char c : ch) {
                if (c != '(' && c != ')') {
                    sb.append(c);
                }
            }

            return sb.toString();
        }

        public void reverse(int start, int end, char[] ch) {
            while (start < end) {
                char tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                start++;
                end--;
            }
            System.out.println(Arrays.toString(ch));
        }
    }

}
