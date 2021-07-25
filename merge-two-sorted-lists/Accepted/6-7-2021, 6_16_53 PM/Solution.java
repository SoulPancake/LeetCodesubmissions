// https://leetcode.com/problems/merge-two-sorted-lists


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        
        for(;l1!=null;l1=l1.next)
        {
            minHeap.add(l1.val);
        }
         for(;l2!=null;l2=l2.next)
        {
            minHeap.add(l2.val);
        }
        
        ListNode dummy=new ListNode(-1);
        ListNode l=dummy;
        
        while(!minHeap.isEmpty())
        {
            l.next=new ListNode(minHeap.remove());
            l=l.next;
        }
        return dummy.next;
        
    }
}