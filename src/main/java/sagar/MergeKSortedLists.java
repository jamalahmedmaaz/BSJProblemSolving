class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        return mergeKLists(lists,0,lists.length-1);
    }
    
    public ListNode mergeKLists(ListNode[] lists,int start,int end) {
        if(start>end) {
            return null;
        }
        if(start==end) return lists[start];
        if(start==end-1) return mergeTwoLists(lists[start],lists[end]);
        int mid = (start+end)/2;
         return mergeTwoLists(mergeKLists(lists,start,mid),mergeKLists(lists,mid+1,end));
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) {
            return null;
        }
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode node=null;
        if(l1.val<l2.val) {
            node = l1;
         node.next=mergeTwoLists(l1.next,l2);
        } else {
            node=l2;
            node.next = mergeTwoLists(l1,l2.next);
        }
        return node;
    }
}
