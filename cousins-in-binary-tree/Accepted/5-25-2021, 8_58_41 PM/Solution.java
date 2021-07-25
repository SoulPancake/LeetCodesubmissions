// https://leetcode.com/problems/cousins-in-binary-tree

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depths = new HashMap<>();
        Map<Integer, Integer> parents = new HashMap<>();
        traverse(root, parents, 0, depths, 0);
        return (parents.get(x) != parents.get(y)) && (depths.get(x) == depths.get(y));
    }
    
    private void traverse(TreeNode root, Map<Integer, Integer> parents, int parent, Map<Integer, Integer> depths, int depth) {
        if (root == null) {
            return;
        }
        parents.put(root.val, parent);
        depths.put(root.val, depth);
        traverse(root.left, parents, root.val, depths, depth + 1);
        traverse(root.right, parents, root.val, depths, depth + 1);
    }
}