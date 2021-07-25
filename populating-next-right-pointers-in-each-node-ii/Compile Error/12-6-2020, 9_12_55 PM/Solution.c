// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *left;
 *     struct Node *right;
 *     struct Node *next;
 * };
 */

struct Node* connect(struct Node* root) {
	 // Rule 1. node->left->next  = node->right
    // Rule 2. node->right->next = node->next->left

    if (root == NULL) return;
    
    struct TreeLinkNode* node = root;
    struct TreeLinkNode* next = root->left;

    while (next) {
        node->left->next  = node->right;

        if (node->next) {
            // Goto next subtree
            node->right->next = node->next->left;
            node              = node->next;
        }
        else {
            // Goto next level
            node = next;
            next = next->left;
} 



  