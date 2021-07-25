// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    
    private Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
    
     for(String t : tokens)
        {
            if(!ops.contains(t))
                s.push(Integer.parseInt(t));
            else
            {
                int a=s.pop();
                int b=s.pop();
                
                if(t.equals("+"))
                {
                    s.push(a+b);
                }else if(t.equals("-"))
                    s.push(b-a);
                else if(t.equals("/"))
                    s.push(b/a);
                else if(t.equals("*"))
                    s.push(b*a);
            }
        }
    
        return s.pop();
    }
}