// https://leetcode.com/problems/remove-nth-node-from-end-of-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    struct ListNode* cur=head;
    struct ListNode* delete=(struct ListNode**)malloc(sizeof(struct ListNode*));
    
    
    int numberOfNodes=0;
    
    for(;cur!=NULL;cur=cur->next)
        numberOfNodes++;
    
    if(numberOfNodes==1)
        return NULL;
    
    cur=head;
    int m=numberOfNodes-n+1;//Aage se position nikal liye
    
    if(m==1)  //Head node to be deleted
    {
        delete=cur;
        head=head->next;
        free(delete);
        return head;
    }
    
    for(int i=1;i<m-1;i++)
    {
       cur=cur->next;
     }    
    delete=cur->next;
    cur->next=cur->next->next;
    free(delete);
    
    return head;
}