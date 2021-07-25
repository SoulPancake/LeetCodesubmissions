// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String S) {
        int top=-1;
        String str="";
        for(int i=0;i<S.length()-1;i++){
           
            if(S.charAt(i)=='('&&++top!=0)
           {
               str+=S.charAt(i);
           }
            else if(S.charAt(i)==')'&&--top!=-1)
            {
                str+=S.charAt(i);
            }
          
        }
        return str;
    }
}