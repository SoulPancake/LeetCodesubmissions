// https://leetcode.com/problems/add-two-numbers

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    int carry = 0;
    struct ListNode* node;
    struct ListNode* last;
    struct ListNode* root = NULL;
    
    if (l1 == NULL && l2 == NULL) {
        return NULL;
    }
    
    node = malloc(sizeof(struct ListNode));
    root = node;
    
    while (l1 != NULL && l2 != NULL) {
        int result = l1->val + l2->val + carry;
        
        l1 = l1->next;
        l2 = l2->next;
        
        node->val = result % 10;
        node->next = malloc(sizeof(struct ListNode));
        last = node;
        node = node->next;
        
        carry = result / 10;
    }
    
    while (l1 != NULL) {
        int result = l1->val + carry;
        
        l1 = l1->next;
        
        node->val = result % 10;
        node->next = malloc(sizeof(struct ListNode));
        last = node;
        node = node->next;
        
        carry = result / 10;
    }
    
    while (l2 != NULL) {
        int result = l2->val + carry;
        
        l2 = l2->next;
        
        node->val = result % 10;
        node->next = malloc(sizeof(struct ListNode));
        last = node;
        node = node->next;
        
        carry = result / 10;
    }
    
    if (carry > 0) {
        node->val = carry;
        node->next = NULL;
    } else {
        free(node);
        last->next = NULL;
    }

    return root;
}