// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        ListNode mid=mid(head);
        TreeNode root=new TreeNode(mid.val);
        
        if(head==mid)
            return root; //Only one node left???
        
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        
    }
    
    private ListNode mid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;
        
        while(fast!=null && fast.next!=null)
        {
            prev=slow; //Previous to middle element
            slow=slow.next;
            fast=fast.next;
        }
        
        if(prev!=null)
        {
            prev.next=null; //Breaks the link between the previous and previous next (mid)
        }
            
         return slow;   
    }
}