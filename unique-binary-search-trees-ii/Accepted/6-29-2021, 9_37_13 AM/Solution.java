// https://leetcode.com/problems/unique-binary-search-trees-ii

class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1, n);
    }
    
    
    public List<TreeNode> helper(int start, int end) {
        
        List<TreeNode> res = new ArrayList<>();
        
        if (start > end) {
            res.add(null);
            return res;
        }
        
        for (int i = start; i <= end; ++i) {
            
            List<TreeNode> leftList = helper(start, i-1);
            List<TreeNode> rightList = helper(i+1, end);
            
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    
                    TreeNode n = new TreeNode(i);
                    n.left = leftNode;
                    n.right = rightNode;
                    
                    res.add(n);
                }
            }
        }
        return res;
    }
}