package jamal.array;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param args
     */

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.solution1(null, null);
    }

    public ListNode solution1(ListNode l1, ListNode l2) {

        ListNode result = recursion(l1, l2, null, null, 0);

        return result;
    }

    public ListNode recursion(ListNode l1, ListNode l2, ListNode result, ListNode tmp, int carry) {


        if (l1 == null && l2 == null) {
            return result;
        } else {
            int addedNumber = 0;

            if (l1 != null) {
                addedNumber = addedNumber + l1.val;
            }

            if (l2 != null) {
                addedNumber = addedNumber + l2.val;
            }


            addedNumber = addedNumber + carry;
            carry = 0;

            int tmpCarry = addedNumber / 10;
            int currentValue = addedNumber % 10;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            if (l1 == null && l2 == null && tmpCarry != 0) {

                if (tmp == null) {
                    result = new ListNode(currentValue);
                    tmp = result;
                    tmp.next = new ListNode(tmpCarry);
                } else {
                    tmp.next = new ListNode(currentValue);
                    tmp.next.next = new ListNode(tmpCarry);
                }

                return result;
            }


            if (tmp == null) {
                result = new ListNode(currentValue);
                tmp = result;
                return recursion(l1, l2, result, tmp, tmpCarry);
            } else {
                tmp.next = new ListNode(currentValue);
                return recursion(l1, l2, result, tmp.next, tmpCarry);
            }


        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
