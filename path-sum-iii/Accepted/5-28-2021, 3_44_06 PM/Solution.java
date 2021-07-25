// https://leetcode.com/problems/path-sum-iii

class Solution {
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();
    
   
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }
    
       public void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;
        currSum += node.val;
        if (currSum == k)
            count++;
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        preorder(node.left, currSum);
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }  
}