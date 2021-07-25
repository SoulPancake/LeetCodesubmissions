// https://leetcode.com/problems/find-bottom-left-tree-value

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        dfs(root, answer, 0);
        return answer.get(answer.size()-1);
    }
    
    
    void dfs(TreeNode node, List<Integer> answer, int level) {
        if(node == null) return;
        if(level + 1 > answer.size()) {
            answer.add(node.val);
        }
        
        dfs(node.left, answer, level+1);
        dfs(node.right, answer, level+1);
    }
}