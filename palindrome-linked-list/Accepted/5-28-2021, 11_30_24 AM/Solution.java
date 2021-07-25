// https://leetcode.com/problems/palindrome-linked-list

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

//Slow pointer Fast Pointer


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        slow=reversed(slow);
        fast=head;
        
        while(slow!=null)
        {
            if(slow.val!=fast.val)
                 return false;
            
            slow=slow.next;
            fast=fast.next;
        }
        
        return true;
    }
    
    private ListNode reversed(ListNode node)
    {
        ListNode prev=null;
        while(node!=null)
        {
            ListNode next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        
        return prev;
    }
}