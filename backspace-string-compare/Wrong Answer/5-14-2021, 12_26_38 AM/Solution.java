// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack=new Stack<Character>();
        for(char c : s.toCharArray())
        {
            if(c!='#')
                sStack.push(c);
            else if(!sStack.isEmpty())
            {
                sStack.pop();
            }
        }
        Stack<Character> tStack=new Stack<Character>();
         for(char c : s.toCharArray())
        {
            if(c!='#')
                tStack.push(c);
            else if(!tStack.isEmpty())
            {
                sStack.pop();
            }
        }
        
        while(!sStack.isEmpty())
        {
            char current=sStack.pop();
            if(tStack.isEmpty() || current!=tStack.pop())
                return false;
        }
        
        return sStack.isEmpty() && tStack.isEmpty();
    }
}