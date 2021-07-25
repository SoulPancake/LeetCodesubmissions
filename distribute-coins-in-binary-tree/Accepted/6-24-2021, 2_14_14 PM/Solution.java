// https://leetcode.com/problems/distribute-coins-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}

/*So I tried for a while to understand the problem and came up with a solution. I hope this explanation helps to anyone struggling to understand. 
Here's my perception:
Imagine a small tree [1,0,2]. We will try to calculate the difference of coins any node needs. To fulfil the difference, it will have to take or give coins to its parent node. It is a bottom-up approach so we don't have to deal with any node's children.
We will start from the left-most leaf which is 0. It gives (-1) coins or takes one coin from the parent to be balanced. So we add a move. Next, we traverse the right child that has 2 coins. It gives 1 coin to the root node, so 1 move. Atlast, we visit the root node, for which difference will be sum of differences from left and right nodes plus its value. For the last root node, the difference will always be 0.
Here's the code:

class Solution {
    private int moves = 0;
    private int current = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root) {
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int diff = left + right + root.val - 1;
        moves += Math.abs(diff);
        return diff;
    }
}

Time Complexity - O(n)
Space Complexity - O(Height of tree)
    */