// https://leetcode.com/problems/linked-list-cycle

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

//Slow pointer and fast pointers
//If there is exists a cycle then the slow and the fast pointer would collide
bool hasCycle(struct ListNode *head) {
    struct ListNode* slowPointer=head;
    struct ListNode* fastPointer=head;
    while(fastPointer!=NULL)
    {
        if(slowPointer==fastPointer)
            return true;
        
        slowPointer=slowPointer->next;
        fastPointer=fastPointer->next->next;
    }
    
    return false;
}