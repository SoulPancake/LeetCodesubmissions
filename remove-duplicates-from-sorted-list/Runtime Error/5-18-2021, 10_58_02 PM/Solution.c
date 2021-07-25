// https://leetcode.com/problems/remove-duplicates-from-sorted-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
   struct ListNode* sorted=head;
    
    int cur=sorted->val;
    
    for(;sorted->next!=NULL;sorted=sorted->next)
    {
        
        if(sorted->next->val==cur)
            sorted->next=sorted->next->next;
        if(sorted->next!=NULL)
        cur=sorted->next->val;
    }
    return head;
}