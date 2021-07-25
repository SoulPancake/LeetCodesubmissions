// https://leetcode.com/problems/next-greater-node-in-linked-list

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
    public int[] nextLargerNodes(ListNode head) {
        ListNode bo=head;
        int l=0;
        for(;bo!=null;bo=bo.next)
            l++;
        
        
        
        int[] NLN=new int[l];
        int k=0;
        ListNode cur=head;
        for(;cur!=null;cur=cur.next)
        {
            int max=0;
            int count=0;
            ListNode inside=cur.next;
            for(;inside!=null;inside=inside.next)
            {
                if(inside.val>cur.val && count==0)
                   { max=inside.val;count=1;}
                else if(inside.val>cur.val)
                    max=Math.min(max,inside.val);
            }
            NLN[k++]=max;
        }
        return NLN;
    }
}