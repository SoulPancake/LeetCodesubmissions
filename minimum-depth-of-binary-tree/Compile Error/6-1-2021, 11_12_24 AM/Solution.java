// https://leetcode.com/problems/minimum-depth-of-binary-tree

public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int minimumDepth = 0;
        
        while (!queue.isEmpty()) {
            minimumDepth++;
            
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // check if this is a leaf node
                if (currentNode.left == null && currentNode.right == null)
                    return minimumDepth;
                
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        
        return minimumDepth;
    }