// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> outputArray=new ArrayList();
        
        backtrack(outputArray,"",0,0,n);
        return outputArray;
    }
    
    private void backtrack(List<String> outputArray,String CurrentString,int open,int close,int max)
    {
        if(CurrentString.length()==max*2)
        {
            outputArray.add(CurrentString);
            return;
        }
        
        if(open<max)backtrack(outputArray,CurrentString+"(",open+1,close,max);
        if(close<open)backtrack(outputArray,CurrentString+")",open,close+1,max);
        
        return;
    }
}