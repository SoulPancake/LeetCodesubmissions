// https://leetcode.com/problems/minimum-absolute-difference-in-bst

void helper(struct TreeNode node, int mdiffp , int *pvalp) {
if (!node) return;
if (node->left) helper(node->left, mdiffp, pvalp);
if (*mdiffp == -2) *mdiffp = -1;
else if (*mdiffp == -1) *mdiffp = node->val - *pvalp;
else if (node->val - *pvalp < *mdiffp) *mdiffp = node->val - *pvalp;
*pvalp = node->val;
if(node->right) helper(node->right, mdiffp, pvalp);
}

int getMinimumDifference(struct TreeNode* root){
int minDiff = -2;
int preVal = 0;
helper(root, &minDiff, &preVal);
return minDiff;
}