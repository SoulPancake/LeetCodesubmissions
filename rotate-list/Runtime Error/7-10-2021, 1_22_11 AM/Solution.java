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
        if(head==null | head.next==null || k==0)return head;
        
        int length=1;
        ListNode cur=head;
        for(;cur.next!=null;cur=cur.next)
            length++;
        k%=length;
        if(k==0)return head;
        
        cur.next=head; //Establishing circular connection
        
        //Now to find the new position of new tail
        
        cur=head;
        for(int i=1;i<length-k;i++)
            cur=cur.next;
        
        //cur is the position of new tail
        
        ListNode newHead=cur.next;
        cur.next=null; //Establishing tail and disconnecting it
        return newHead;
    }
}