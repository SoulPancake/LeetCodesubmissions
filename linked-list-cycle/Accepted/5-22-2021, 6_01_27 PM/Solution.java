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
        HashSet<ListNode> set=new HashSet<>();
        
        ListNode current=head;
        
        for(;current!=null;current=current.next)
        {
            if(set.contains(current))
                return true;
            
            set.add(current);
        }
        return false;
    }
}