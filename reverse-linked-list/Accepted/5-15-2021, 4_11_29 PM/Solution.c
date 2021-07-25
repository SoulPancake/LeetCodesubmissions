// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode* ptr = NULL;
    helper(NULL, head, &ptr);
    return ptr;
}

void helper(struct ListNode* prev, struct ListNode* cur, struct ListNode** head){
    if(cur == NULL){
        *head = prev;
    } else {
        helper(cur, cur->next, head);
        cur->next = prev;
    }
}