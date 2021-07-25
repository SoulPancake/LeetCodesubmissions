// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int openingParentheses=0;
        
        for(char c : s.toCharArray())
        {
            if(c=='(')
                openingParentheses++;
            else if(c==')')
                {if(openingParentheses==0)
                    continue;
                openingParentheses--;}
        
             sb.append(c);
        }
        
        StringBuilder result=new StringBuilder();
        
        for(int i=sb.length()-1;i>=0;i--)
        {
            if(sb.charAt(i)=='(' && openingParentheses-->0) continue;
            result.append(sb.charAt(i));
        }
        
 
        
        return result.reverse().toString();
    }
}

//()( For this we have to remove the  (
// )( for this we have to remove both of the parentheses
// ))(( All of these characters gotta go
