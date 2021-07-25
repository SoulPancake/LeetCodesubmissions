// https://leetcode.com/problems/remove-linked-list-elements

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null)
            return null;
        if(head.val==val)
        {
            while(head!=null && head.val==val)
             head=head.next;
        }
        ListNode temp=head;
        while(temp!=null && temp.next!=null)
        {
            if(temp.next.val==val)
                temp.next=temp.next.next;
            else
                temp=temp.next;
        }
        return head;
    }
}