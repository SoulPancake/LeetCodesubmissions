// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root=new ListNode(0,head);
        ListNode cur=head;
        ListNode prev=root;
        
        while(cur!=null)
        {
            ListNode tail=cur;
            int listIndex=0;
            while(cur!=null && listIndex<k)
            {
                cur=cur.next;
                listIndex++;
            }
            
            if(listIndex!=k){
                prev.next=tail;
            }else{
                prev.next=reverse(tail,k);
                prev=tail;
            }
        }
        return root.next;
    }
    
    private ListNode reverse(ListNode head,int k)
    {
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;
        
        while(cur!=null && k-- >0)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
        return head;
        
    }
}