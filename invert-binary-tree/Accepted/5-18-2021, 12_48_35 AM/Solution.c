// https://leetcode.com/problems/invert-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
//post order processing

struct TreeNode* invertTree(struct TreeNode* root){
    if(root==NULL)
        return NULL;
    
    invertTree(root->left);
    invertTree(root->right);
    
     struct TreeNode*temp=root->left;
     root->left=root->right;
     root->right=temp;
        
    return root;
}