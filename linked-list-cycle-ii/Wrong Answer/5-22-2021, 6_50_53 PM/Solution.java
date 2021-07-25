// https://leetcode.com/problems/linked-list-cycle-ii

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        
        ListNode slowPointer=head;
        ListNode fastPointer=head;
        
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            
            if(slowPointer==fastPointer)
            {
                return slowPointer.next;
            }
            
        }
        
        return null;
    }
}