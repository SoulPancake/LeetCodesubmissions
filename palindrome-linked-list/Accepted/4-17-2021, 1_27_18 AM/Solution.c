// https://leetcode.com/problems/palindrome-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */



struct ListNode* helper(struct ListNode* current, struct ListNode* head, bool* ans)
{
    if(current == NULL)
    {
        return head;
    }
    else
    {
        head = helper(current -> next, head, ans);
        if(*ans)
        {
            if(current -> val != head -> val)
            {
                *ans = false;
                return head -> next;
            }
            else
            {
                return head -> next;
            }
        }
    }
    return head;
}

bool isPalindrome(struct ListNode* head) {
    bool* ans = malloc(sizeof(bool));
    *ans = true;
    helper(head, head, ans);
    return *ans;
}