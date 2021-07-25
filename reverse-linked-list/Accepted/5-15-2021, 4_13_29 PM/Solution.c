// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseList(struct ListNode* head) {
    if (! head || ! head->next)
		return head;
 
	struct ListNode *next=head->next;
	head->next=NULL;
	struct ListNode *newNode=reverseList(next);
	next->next=head;
	return newNode;
}

