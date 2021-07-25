// https://leetcode.com/problems/binary-tree-right-side-view

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        int[] levels = new int[1001];
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0,levels);
        return list;
    }
    
    private void dfs(TreeNode currNode, List<Integer> list, int level,int[] levels){
        if(null == currNode){
            return;
        }
        //Pre-Order
        if(levels[level] == 0){
            list.add(currNode.val);
            levels[level] = 1;
        }
		
		//Process right child first
        dfs(currNode.right,list,level+1,levels);
        
        dfs(currNode.left,list,level+1,levels);
    }
}