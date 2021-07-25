// https://leetcode.com/problems/generate-parentheses

class Solution {
    
    static List<String> ans = new ArrayList<>();
    
    static void generate(int n,int open, int close, char[] path, int idx){
        
        if(n == close){
            String text = String.copyValueOf(path);
            
            ans.add(text);
            return;
        }
        if(idx >= 2*n)
        {
            return;
        }
        
        if(open  < n ){
            path[idx] = '(';
            generate(n, open+1, close, path, idx+1);
            path[idx] = '#';
        }
        if(close < n && close< open){
            path[idx] = ')';
            generate(n, open, close+1, path, idx+1);
            path[idx] = '#';
        }
        
        
    }
    
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        char[] path = new char[2*n];
        generate(n, 0, 0, path, 0);
        
        return ans;
    }
}