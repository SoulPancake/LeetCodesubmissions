// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

class Solution {
    
    public int postRootIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        postRootIndex = postorder.length - 1;
        
        return Util(inorder, postorder, map, 0, inorder.length - 1);
    }
    
    public TreeNode Util(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        if(start > end) 
            return null;
        
        TreeNode root = new TreeNode(postorder[postRootIndex--]);
        
        if(start == end)
            return root;
        
        int inRootIndex = map.get(root.val);
        
        root.right = Util(inorder, postorder, map, inRootIndex + 1, end);
        root.left = Util(inorder, postorder, map, start, inRootIndex - 1);
        return root;
    }
    
}