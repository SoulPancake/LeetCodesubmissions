// https://leetcode.com/problems/subtree-of-another-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

bool isSameTree(struct TreeNode* root,struct TreeNode* subRoot)
{
    if(root==NULL || subRoot==NULL)
        return (root==NULL && subRoot==NULL);
    else if(root->val==subRoot->val)
    {
        return isSameTree(root->left,subRoot->left) && isSameTree(root->right,subRoot->right);
    }else
    {
        return false;
    }
        
}


bool isSubtree(struct TreeNode* root, struct TreeNode* subRoot){
    if(root==NULL )
        return false;
    else if(isSameTree(root,subRoot))
        return true;
    else
        return isSubtree(root->left,subRoot) || isSubtree(root->right,subRoot);
    
}

