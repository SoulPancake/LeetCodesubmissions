// https://leetcode.com/problems/binary-tree-right-side-view

class Solution {
// Tip :--// Declare result ArrayList in global, Which definitely increase speed. 
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        showRightView(root, 0);
        
    return result;
    }
    
    public void showRightView(TreeNode node, int nodeCount){
        if(node == null)
            return;
        
        if(result.size() == nodeCount)
            result.add(node.val);
        
        showRightView(node.right , nodeCount+1);
        showRightView(node.left , nodeCount+1);
    }
}