// https://leetcode.com/problems/unique-binary-search-trees-ii

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1 , n);
    }
    
    public ArrayList<TreeNode> dfs(int start , int end){
        if(start == end){
            ArrayList<TreeNode> x = new ArrayList<>();
            x.add(new TreeNode(start));
            return x;
        }
        ArrayList<TreeNode> ans = new ArrayList<>();
        for(int i=start;i<=end;i++){
            
            ArrayList<TreeNode> left = new ArrayList<>(1);
            
            ArrayList<TreeNode> right = new ArrayList<>(1);
            
            if(i!=start)
                left = dfs(start , i-1);
            else
                left.add(null);
            
            if(i != end)
                right = dfs(i+1 , end);
            else
                right.add(null);
            
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode head = new TreeNode(i);
                    head.left = left.get(j);
                    head.right = right.get(k);
                    ans.add(head);
                }
            } 
        }
        return ans;
    }
}