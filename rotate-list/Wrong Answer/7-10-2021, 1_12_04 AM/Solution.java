// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null)return head;
        int count=1;
        ListNode cur=head;
        for(;cur.next!=null;cur=cur.next)
        {
            count++;
        }
        cur.next=head; //Establish circular connection
        k=k%count;
        if(k==0)return head; //Multiple of length
        
        ListNode newTail=head;
        for(int i=1;i<count-k;i++)
            newTail=newTail.next;
        
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
        
        
        
        
        
    }
}