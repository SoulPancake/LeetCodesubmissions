// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseList(struct ListNode* head){
if(head==NULL || head->next==NULL)
    {
        return head;
    }
    struct ListNode* headnew=(struct ListNode*)malloc(sizeof(struct ListNode));
    headnew->val=head->val;
    headnew->next=NULL;
    head=head->next;
    while(head!=NULL)
    {
        struct ListNode* tmp=headnew;
        headnew=head;            
        head=head->next;
        headnew->next=tmp;
    }
    return headnew;
}