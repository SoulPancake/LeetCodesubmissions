// https://leetcode.com/problems/remove-nth-node-from-end-of-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    struct ListNode* cur=head;
    struct ListNode* delete;
    
    
    int numberOfNodes=0;
    
    for(;cur!=NULL;cur=cur->next)
        numberOfNodes++;
    
    cur=head;
    int m=numberOfNodes-n+1;
    
    for(int i=1;i<m;i++)
    {
       cur=cur->next;
     }    
    delete=cur->next;
    cur->next=cur->next->next;
    free(delete);
}