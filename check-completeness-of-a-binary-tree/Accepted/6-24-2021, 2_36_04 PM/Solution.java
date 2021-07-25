// https://leetcode.com/problems/check-completeness-of-a-binary-tree

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean seenAnull=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode currentNode=queue.poll();
            if(currentNode==null)
                seenAnull=true; //THE FIRST NULL THAT YOU SEE
            else
            {
                if(seenAnull)  //SHOULD BE THE LAST NULL VALUE 
                    return false; //This condition basically says that if it has already seen a null and and and there's more nodesw which are not null still remaining then that is not a complete binary tree so we simply return false!
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        
        return true;
    }
}