// https://leetcode.com/problems/reverse-nodes-in-k-group

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, temp = head, next = null, prev = null;
        int count = 0;

        while (temp != null && count != k) {
            temp = temp.next;
            count++;
        }

        if (count != k) return head;

        while (curr != null && count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}