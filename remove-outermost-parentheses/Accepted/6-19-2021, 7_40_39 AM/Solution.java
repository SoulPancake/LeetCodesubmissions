// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String s) {

        String newString = "";

        Stack<Integer> myStack = new Stack<Integer>();

        char[] chars = s.toCharArray();
        boolean[] positions = new boolean[s.length()];
        
        for (int i = 0; i < chars.length; i++) {

            if(chars[i] == '('){
                myStack.push(i);
            }
            if(chars[i] == ')'){
                int pos = myStack.pop();
                if (myStack.isEmpty()){
                    
                    positions[i] = true;
                    positions[pos] = true;
                    
                }
            }

        }
        
        

        for (int i = 0; i < s.length(); i++) {
            
            if (!positions[i] ) newString+= chars[i];
            
        }

        return newString;
    }
}