// https://leetcode.com/problems/maximum-depth-of-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


int maxDepth(struct TreeNode* root){
     if(root==NULL)
         return 0;
    
    
    int depth=0;
         depth+=1+maxDepth(root->left)+maxDepth(root->right);
    return depth;
}