// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    HashMap<Integer,Node> visited;
    public Node cloneGraph(Node node) {
        if(node==null)return null; 
        visited=new HashMap<>();
        
        return helper(node);
        
        
    }
    
    private Node helper(Node node)
    {
        
        Node root=new Node(node.val);
        visited.put(node.val,root);
        
        
        for(Node c : node.neighbors)
        {
           if(visited.containsKey(c.val))
           {
               root.neighbors.add(visited.get(c.val));
           }else
           {    
               root.neighbors.add(helper(c));
           }
        }
        
        return root;
        
    }
}