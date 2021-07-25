// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> S=new Stack<ListNode>();
        while(head!=null)
        { 
          S.push(head);
          head=head.next;
        }
        
        ListNode dummy=new ListNode(-1);
        head=dummy;
        while(!S.isEmpty())
        {
            ListNode current=S.pop();
            head.next=new ListNode(current.val);
            head=head.next;
        }
        
        return dummy.next;
    }
}