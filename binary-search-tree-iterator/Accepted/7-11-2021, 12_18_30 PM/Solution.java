// https://leetcode.com/problems/binary-search-tree-iterator

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
class BSTIterator {
    TreeNode root;
    List<Integer> inOrder=new ArrayList<>();
    int k=0;
    public BSTIterator(TreeNode root) {
        this.root=root;
        helper(root);
    }
    private void helper(TreeNode root)
    {
        if(root==null)return;
        helper(root.left);
        inOrder.add(root.val);
        helper(root.right);
        return;
    }
    
    public int next() {
        return inOrder.get(k++);
    }
    
    public boolean hasNext() {
        return k<inOrder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */