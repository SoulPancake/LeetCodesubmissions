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
    
  while(sorted!=NULL && sorted->next!=NULL)
  {
      if(sorted->next->val==sorted->val)
          sorted->next=sorted->next->next;
      else
          sorted=sorted->next;
      
  }
    return head;
}