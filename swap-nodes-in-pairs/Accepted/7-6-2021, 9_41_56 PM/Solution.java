// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode();
        temp.next=head;
        
        ListNode cur=temp;
        
        while(cur.next!=null && cur.next.next!=null)
        {
            ListNode firstNode=cur.next;
            ListNode secondNode=cur.next.next;
            firstNode.next=secondNode.next;
            cur.next=secondNode;
            secondNode.next=firstNode;
            cur=cur.next.next;
            
        }
        return temp.next;
    }
}