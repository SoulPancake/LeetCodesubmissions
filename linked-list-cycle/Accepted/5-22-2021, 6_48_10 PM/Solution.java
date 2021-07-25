// https://leetcode.com/problems/linked-list-cycle

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
//Brute Force Solution using HashSet

public class Solution {
    public boolean hasCycle(ListNode head) {
       if(head==null || head.next==null)
           return false;
        
        ListNode slowPointer=head;
        ListNode fastPointer=head;
        
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            
            if(slowPointer==fastPointer)
                return true;
        }
        
        return false;
    }
}