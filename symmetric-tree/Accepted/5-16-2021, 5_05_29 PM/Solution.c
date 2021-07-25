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
bool isSymmetricRecursion(struct TreeNode* left,struct TreeNode* right)
{
    if(left==NULL || right==NULL)
        return (left==right);
    
    if(left->val!=right->val)
        return false;
    
    return isSymmetricRecursion(left->left,right->right) && isSymmetricRecursion(left->right,right->left);
        
}

bool isSymmetric(struct TreeNode* root){
    if(root==NULL)
        return true;
    
    return isSymmetricRecursion(root->left,root->right);
}