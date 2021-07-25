// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
            rootToNodePath(root,p,path1);
        ArrayList<TreeNode> path2=new ArrayList<>();
            rootToNodePath(root,q,path2);
        if(rootToNodePath(root,p,path1)==false || rootToNodePath(root,q,path2)==false){
            return null;
        }
        for(int i=0;i<path1.size()-1 && i<path2.size()-1;i++){
            if(path1.get(i+1)!=path2.get(i+1)){
                return path1.get(i);
            }
        }
        return null;
    }
    public boolean rootToNodePath(TreeNode root,TreeNode node,ArrayList<TreeNode> ans){
        if(root==null){
            return false;
        }
        ans.add(root);
        if(root.val==node.val){
            return true;
        }
        if(rootToNodePath(root.left,node,ans) || rootToNodePath(root.right,node,ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
}