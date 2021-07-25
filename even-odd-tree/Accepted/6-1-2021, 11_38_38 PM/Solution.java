// https://leetcode.com/problems/even-odd-tree

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean evenlevel=true;
        
        while(!q.isEmpty())
        {
            int size=q.size();
            int prev = evenlevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;//if even level strictly increasing order else strictly decreasing order
            while(size-- > 0)
            {
                root=q.poll();
                if(evenlevel && (prev >= root.val || root.val % 2==0))
                    //if incase its in even level but doesnt satisy the 2 conditions,that is,if it isnt odd number or not in strictly increasing order then false
                    return false;
                 if(!evenlevel && (prev <= root.val || root.val % 2==1))
                    //if incase its in odd level but doesnt satisy the 2 conditions,that is,if it isnt even number or not in strictly decreasing order then false
                    return false;
                prev=root.val;
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);
            }
            evenlevel=!evenlevel;
       }
        return true;
  }
}