// https://leetcode.com/problems/unique-binary-search-trees-ii

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
  public List<TreeNode> generateTrees(int n) {
        List[][] dp = new List[n+1][n+1];
        List<TreeNode>  res =  generateTrees(1,n,dp);
        return res;
    }

    public List<TreeNode> generateTrees(int start,int end,List[][] dp) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }

        if (dp[start][end] != null)
            return dp[start][end];

        if (start == end) {
            res.add(new TreeNode(start));
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubtree = generateTrees(start, i - 1, dp);
                List<TreeNode> rightSubtree = generateTrees(i + 1, end, dp);

                for (TreeNode left : leftSubtree) {
                    for (TreeNode right : rightSubtree) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = left;
                        treeNode.right = right;
                        res.add(treeNode);
                    }
                }
            }
        }
        dp[start][end] = res;
        return res;
    }
}