// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


struct TreeNode* construct(int* preorder,int left,int right)
{
    if(left>right)
        return NULL;
    struct TreeNode* root=malloc(sizeof(struct TreeNode));
    root->left=NULL;  //The main problem is the children in the last element isn't set to NULL.
    root->right=NULL;
    root->val=preorder[left];
    
    if(left==right)
        return root;
    
    int index=left+1;
    while(index<=right && preorder[index]<preorder[left])
         index++;
    
    root->left=construct(preorder,left+1,index-1);
    root->right=construct(preorder,index,right);
    return root;
    
}



struct TreeNode* bstFromPreorder(int* preorder, int preorderSize){
    if(preorderSize==0)
        return NULL;
    
    return construct(preorder,0,preorderSize-1);
        
}
