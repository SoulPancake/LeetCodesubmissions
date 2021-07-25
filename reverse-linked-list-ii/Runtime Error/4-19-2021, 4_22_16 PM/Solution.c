// https://leetcode.com/problems/reverse-linked-list-ii

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseBetween(struct ListNode* head, int left, int right){
  
    int values[right-left+1];
    int k=0;
    
    struct ListNode* cur=head;
    
    for(int i=0;i<right;i++)
    {
        cur=cur->next;
        if(i>=left-1)
        {
            values[k++]=cur->val;
        }
    }
    cur=head;
     for(int i=0;i<right;i++)
    {
        cur=cur->next;
        if(i>=left-1)
        {
            cur->val=values[k--];
        }
    }
    
    return head;
}