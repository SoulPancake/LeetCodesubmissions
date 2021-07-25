// https://leetcode.com/problems/path-sum-ii

class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList();
        }
        dfs(root,targetSum);
        return this.result;
    }
    private void dfs(TreeNode n, int targetSum){
        this.list.add(n.val);
        if(n.left==null&&n.right==null&& targetSum == n.val){
            this.result.add(new ArrayList(this.list));
        }
        if(n.left!=null){
            dfs(n.left, targetSum-n.val);
        }
        if(n.right!=null){
            dfs(n.right,targetSum-n.val);
        }
        this.list.remove(this.list.size()-1);
    }
}