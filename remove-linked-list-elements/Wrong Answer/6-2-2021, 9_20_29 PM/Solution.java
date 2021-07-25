// https://leetcode.com/problems/remove-linked-list-elements

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        if(head.val==val)
            head=head.next;
        ListNode current=head;
        ListNode prev=null;
        for(;current!=null;current=current.next)
        {
            if(current.val==val)
            {if(prev!=null)
                prev.next=current.next;
                continue;
            }
            prev=current;
        }
        return head;
    }
}