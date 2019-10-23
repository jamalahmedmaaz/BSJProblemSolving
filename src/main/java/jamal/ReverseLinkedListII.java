package jamal;

import java.util.Deque;
public class ReverseLinkedListII {
    public static void main(String[] args) {
        Deque dq = null;

        Solution solution = new Solution();
        ListNode head = null;
        ListNode tmpHead = null;
        for (int i = 5; i > 0; i--) {
            if (head == null) {
                tmpHead = head = new ListNode(i);
            } else {
                ListNode n = new ListNode(i);
                n.next = tmpHead;
                tmpHead = n;
            }
        }
        head = tmpHead;
        ListNode l = head;
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

        solution.reverseBetween(head, 2, 4);

    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode tmpHead = head;
            ListNode xPointer = null;
            ListNode tail = null;
            ListNode previous = null;
            int count = 1;

            while (tmpHead != null) {
                System.out.println(tmpHead.val);
                if (count == m) {
                    while (tmpHead != null && count <= n) {
                        if (xPointer == null) {
                            if (previous != null) {
                                previous.next = null;
                            }
                            ListNode x = tmpHead;
                            x.next = null;
                            xPointer = x;
                            tail = x;
                        } else {
                            previous.next = null;
                            ListNode x = tmpHead;
                            x.next = null;
                            x.next = xPointer;
                            xPointer = x;
                        }
                        previous = tmpHead;
                        tmpHead = tmpHead.next;
                        count++;
                    }
                    previous.next = tail;

                } else {
                    tmpHead = tmpHead.next;
                }
                count++;
            }

            return head;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
