/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) {
            return l1;
        }
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        ListNode head=null;
        ListNode current = null;
        int carry=0;
        while(l1!=null && l2!=null) {
            int sum = l1.val + l2.val + carry;
            if(sum>9) {
                carry = sum/10;
                sum=sum%10;
            } else{
                carry=0;
            }
            if(head==null) {
                head = new ListNode(sum);
                current=head;
            } else {
                current.next = new ListNode(sum);
                current=current.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null) {
            int sum = l1.val + carry;
            if(sum>9) {
                carry = sum/10;
                sum=sum%10;
            }else {
            carry=0;
            }
            current.next = new ListNode(sum);
            current=current.next;
            l1=l1.next;
        }
        while(l2!=null) {
            int sum = l2.val+carry;
            if(sum>9) {
            carry = sum/10;
                sum=sum%10;
            }else {
            carry=0;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l2=l2.next;
        }
        if(carry>0) {
            current.next = new ListNode(carry);
        
        }
        return head;
    }
}
