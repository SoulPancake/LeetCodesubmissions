// https://leetcode.com/problems/binary-tree-cameras

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int cameras;

int dfs(struct TreeNode* root)
{
    if(root==NULL) //The children of leaf nodes are covered obviously
        return 1;
    
    //Now reach the leaf nodes
    
     int left=dfs(root->left);
     int right=dfs(root->right);
    
    if(left==0 || right==0) //Either right child or left child are not covered
    {
        cameras++;    //Add a camera to this node 
        return 2; 
    }else if(left==2 || right==2)
    {
        return 1;   //This node is covered
    }else
        return 0; //It's not covered
}

int minCameraCover(struct TreeNode* root){
    cameras=0;
    
    int ans=dfs(root);
    /*If dfs of root returns
       0  --> It is not covered so return cameras+1
       1  --> It is covered so return cameras
       2  --> Camera hai is node pe
      */
    return (ans==0)? cameras+1:cameras;
       
}