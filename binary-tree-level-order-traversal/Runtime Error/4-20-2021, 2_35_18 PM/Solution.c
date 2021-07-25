// https://leetcode.com/problems/binary-tree-level-order-traversal

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

void traverse(struct TreeNode *root, int depth, int ***arr, int **columnSizes, int *returnSize)
{
    if (!root) return;

    if (*returnSize < depth + 1) {
        *returnSize = depth + 1;
        
        /*
         * Should initialise the one more allocated space to NULL (or 0)
         */
        *arr = realloc(*arr, (depth + 1) * sizeof(int *));
        (*arr)[depth] = NULL;
    
        *columnSizes = realloc(*columnSizes, (depth + 1) * sizeof(int));
        (*columnSizes)[depth] = 0;
    }
    
    (*arr)[depth] = realloc((*arr)[depth], ((*columnSizes)[depth] + 1) * sizeof(int));
    (*arr)[depth][(*columnSizes)[depth]] = root->val;
    ++(*columnSizes)[depth];
    
    traverse(root->left, depth + 1, arr, columnSizes, returnSize);
    traverse(root->right, depth + 1, arr, columnSizes, returnSize);
}

int** levelOrder(struct TreeNode* root, int** columnSizes, int* returnSize) {
    int **arr;
    
    arr = NULL;
    *returnSize = 0;
    traverse(root, 0, &arr, columnSizes, returnSize);
    
    return arr;
}