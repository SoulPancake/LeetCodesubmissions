// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    class TreeNode {
        int val;
        int height;
        
        int freq;       // frequency of node with val
        int countLeft;  // number of nodes in TreeNode left (with smaller value than val)
        
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
            this.freq = 1;
            this.countLeft = 0;
        }
    }
    
    class AVLTree {
        TreeNode root;
        
        AVLTree(int val) {
            this.root = new TreeNode(val);
        }

        void updateHeight(TreeNode n) {
            n.height = 1 + Math.max(height(n.left), height(n.right));
        }

        int height(TreeNode n) {
            return n == null ? -1 : n.height;
        }

        int getBalance(TreeNode n) {
            return (n == null) ? 0 : height(n.right) - height(n.left);
        }
        
        TreeNode rotateRight(TreeNode y) {
            TreeNode x = y.left;
            TreeNode B = x.right;
            x.right = y;
            y.left = B;
            
            y.countLeft = y.countLeft - x.countLeft - x.freq;
            
            updateHeight(y);
            updateHeight(x);
            return x;
        }
        
        TreeNode rotateLeft(TreeNode y) {
            TreeNode x = y.right;
            TreeNode B = x.left;
            x.left = y;
            y.right = B;
            
            x.countLeft = x.countLeft + y.countLeft + y.freq;
            
            updateHeight(y);
            updateHeight(x);
            return x;
        }
        
        TreeNode rebalance(TreeNode z) {
            updateHeight(z);
            int balance = getBalance(z);
            if (balance > 1) {
                if (height(z.right.right) > height(z.right.left)) {
                    z = rotateLeft(z);
                } else {
                    z.right = rotateRight(z.right);
                    z = rotateLeft(z);
                }
            } else if (balance < -1) {
                if (height(z.left.left) > height(z.left.right))
                    z = rotateRight(z);
                else {
                    z.left = rotateLeft(z.left);
                    z = rotateRight(z);
                }
            }
            return z;
        }
        

        int total = 0;  // recording the result after each insertion
        
        TreeNode insert(TreeNode node, int key, int count) {
            if (node == null) {
                total = count;
                return new TreeNode(key);
            }
            
            
            if (node.val > key) {
                node.countLeft++;
                
                node.left = insert(node.left, key, count);
            } else if (node.val < key){
                count = count + node.countLeft + node.freq;
                
                node.right = insert(node.right, key, count);
            } else {
                node.freq++;
                count = count + node.countLeft;
                
                total = count;
            }
            
            return rebalance(node);
        }        
  
    }
    
    
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        
        int n = nums.length;
        AVLTree avlTree = new AVLTree(nums[n-1]);
        res.add(0);
        
        for (int i = n-2; i >= 0; i--) {
            avlTree.root = avlTree.insert(avlTree.root, nums[i], 0);
        
            res.add(0, avlTree.total);
            avlTree.total = 0;
        }
        
        return res;
    }
}