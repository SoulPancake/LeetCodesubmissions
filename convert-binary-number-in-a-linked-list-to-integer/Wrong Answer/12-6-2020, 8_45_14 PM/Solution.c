// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

#include<math.h>
int getDecimalValue(struct ListNode* head){
   struct ListNode *ptr;
    int i=0;
    for(ptr=head;ptr->next!=NULL;ptr=ptr->next)
         i++;
    
    int sum=0;
    for(ptr=head;ptr->next!=NULL;ptr=ptr->next)
    {
        sum=sum+ptr->val*pow(2,i--);
    }
    return sum+1;
    
}