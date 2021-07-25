// https://leetcode.com/problems/palindrome-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

bool help(struct ListNode **left, struct ListNode *right) {
    
    bool palin;
    
    if(right == NULL)
        return true;
    
    palin = help(left, right->next);
    if(palin == false)
        return false;
    
    if((*left)->val == right->val) {
        
        *left = (*left)->next;
        return true;
    }
    else
        return false;
    
}
bool isPalindrome(struct ListNode* head){
    
    
    return help(&head, head);
}