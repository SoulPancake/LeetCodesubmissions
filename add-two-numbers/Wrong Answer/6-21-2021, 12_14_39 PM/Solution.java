// https://leetcode.com/problems/add-two-numbers

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

//They are already in reversed order!
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        
        ListNode l3=dummy;
        int carry=0;
        while(l1!=null && l2!=null)
        {
            int l1_value=(l1!=null)?l1.val:0;
            
            int l2_value=(l2!=null)?l2.val:0;
            
            
            int currentSum=l1_value+l2_value+carry;
            carry=currentSum/10;
            int lastDigit=currentSum%10;
            ListNode newNode=new ListNode(lastDigit);
            l3.next=newNode;
            if(l1!=null)l1=l1.next;
            if(l2!=null);l2=l2.next;
            
            l3=l3.next;
        }
        
        if(carry>0)
        {
            ListNode newNode=new ListNode(carry);
            l3.next=newNode;
            l3=l3.next;
        }
        
        return dummy.next;
    }
}