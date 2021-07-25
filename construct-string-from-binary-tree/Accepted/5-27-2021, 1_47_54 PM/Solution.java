// https://leetcode.com/problems/construct-string-from-binary-tree

class Solution {
    private void helper(TreeNode root, StringBuilder str){
        if(root == null){
            return;
        }
        str.append(root.val);
        
        if(root.left != null || root.right != null){
            str.append("(");
            helper(root.left, str);
            str.append(")");
        }
        
        if(root.right != null){
            str.append("(");
            helper(root.right, str);
            str.append(")");
        }
    }
    
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        helper(root, str);
        return str.toString();
    }
}