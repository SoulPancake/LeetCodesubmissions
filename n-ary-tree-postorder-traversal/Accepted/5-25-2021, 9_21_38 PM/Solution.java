// https://leetcode.com/problems/n-ary-tree-postorder-traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> l;
    public List<Integer> postorder(Node root) {
        l=new ArrayList<>();
        
        recurse(root);
        return l;
    }
    
    private void recurse(Node root)
    {
        if(root==null) return;
        
        for(int i=0;i<root.children.size();i++)
        {
            recurse(root.children.get(i));
        }
        l.add(root.val);
        return;
    }
}
