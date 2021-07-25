// https://leetcode.com/problems/maximum-depth-of-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int max(int a,int b)
{
    if(a>=b)
        return a;
    return b;
}


int maxDepth(struct TreeNode* root){
     if(root==NULL)
         return 0;
    
    int left=maxDepth(root->left);
    int right=maxDepth(root->right);
    return max(left,right)+1; //+1 because of it's own count and the max of it's children
                              //pathways,2 pathways
    
}