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
    
    if(head==NULL || head->next==NULL)
        return false;
    struct ListNode* slowPointer=head;
    struct ListNode* fastPointer=head;
    while(fastPointer->next!=NULL && fastPointer->next->next!=NULL)
    {fastPointer=fastPointer->next->next;
     slowPointer=slowPointer->next;
        if(slowPointer==fastPointer)
            return true;
        
        
        
    }
    
    return false;
}