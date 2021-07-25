// https://leetcode.com/problems/n-ary-tree-preorder-traversal



class Solution {
    List<Integer> l;
    public List<Integer> preorder(Node root) {
        l=new ArrayList<>();
        
        recurse(root);
        return l;
    }
    
    private void recurse(Node root)
    {
        if(root==null) return;
         l.add(root.val);
        for(int i=0;i<root.children.size();i++)
        {
            recurse(root.children.get(i));
        }
       
        return;
    }
}
