// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


int getDecimalValue(struct ListNode* head){
int sum=0;
    while(head){
        sum += head->val;
        sum <<= 1;
        head = head->next;
    }
    sum >>= 1;
    
    return sum;
}