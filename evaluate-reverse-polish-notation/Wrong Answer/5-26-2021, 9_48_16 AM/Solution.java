// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
    for(int i=0;i<tokens.length;i++)
    { for(char c : tokens[i].toCharArray())
        {
            if(Character.isDigit(c))
                s.push(Character.getNumericValue(c));
            else
            {
                int a=s.pop();
                int b=s.pop();
                
                if(c=='+')
                {
                    s.push(a+b);
                }else if(c=='-')
                    s.push(b-a);
                else if(c=='/')
                    s.push(b/a);
                else if(c=='*')
                    s.push(b*a);
            }
        }
    }
        return s.pop();
    }
}