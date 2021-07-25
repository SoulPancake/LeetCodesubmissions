// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

class Solution {
public TreeNode buildTree(int[] preorder, int[] inorder) {

    int root = preorder[0];
    
    List<Integer> leftTree = new LinkedList<>();
    List<Integer> rightTree = new LinkedList<>();
    
    boolean foundRoot = false;
    for(int i=0;i<inorder.length;i++){
        if(inorder[i] == root){
            foundRoot = true;
        }
        
        if(foundRoot ){
            rightTree.add(inorder[i]);
        }else{
            leftTree.add(inorder[i]);
        }
    }
    
    rightTree.remove(0);
    
    
    List<Integer> leftTreePreOrder = new LinkedList<>();
    List<Integer> rightTreePreOrder = new LinkedList<>();
    
    for(int i=0;i<preorder.length;i++){
        if(leftTree.contains(preorder[i])){
            leftTreePreOrder.add(preorder[i]);
        }
    }
    
     for(int i=0;i<preorder.length;i++){
        if(rightTree.contains(preorder[i])){
            rightTreePreOrder.add(preorder[i]);
        }
    }
    
    TreeNode leftTreeNode = buildBinaryTree(leftTreePreOrder);
    TreeNode rightTreeNode = buildBinaryTree(rightTreePreOrder);
    
    TreeNode rootNode = new TreeNode(root,leftTreeNode, rightTreeNode);
    
    return rootNode;
}


private TreeNode buildBinaryTree(List<Integer> vals){
   TreeNode root = null;
    
    for(int i=0;i<vals.size();i++){
        TreeNode node = new TreeNode(vals.get(i), null, null);
    
        if(root == null){
            root = node;
        }else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size() > 0){
                 TreeNode currNode = queue.poll();

                if(currNode.left != null){
                    queue.add(currNode.left);
                }else{
                    currNode.left = node;
                    break;
                }

                if(currNode.right != null){
                    queue.add(currNode.right);
                }else{
                    currNode.right = node;
                    break;
                }
            }
        }
    }
    
    return root;
}
}