// https://leetcode.com/problems/symmetric-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
// 

bool isSymmetric(struct TreeNode* root){
    if(root==NULL)
        return;
    
    return (root->left==root->right) && isSymmetric(root->left) && isSymmetric(root->right);
}