// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        //So let's creat ethe utput data striuctrue fiorsty
        
        List<String> outputList=new ArrayList<>();
        
        //Magical backtrack functionj
         backtrack(outputList,"",0,0,n);
        
         return outputList;
    }
    
    private void backtrack(List<String> outputList,String currentString,int openingParentheses,int closingParentheses,int maxParentheses)
    {
        if(currentString.length()==maxParentheses*2)//base case
        {
            outputList.add(currentString);
            return;
        }
        
        if(openingParentheses<maxParentheses)
            backtrack(outputList,currentString+"(",openingParentheses+1,closingParentheses,maxParentheses);
        
        if(closingParentheses<openingParentheses)
            backtrack(outputList,currentString+")",openingParentheses,closingParentheses+1,maxParentheses);
        
        return;
    }
}

//Backtracking problem because Permutations bleh bleh 2^n ish thing
//Fuck off bitch