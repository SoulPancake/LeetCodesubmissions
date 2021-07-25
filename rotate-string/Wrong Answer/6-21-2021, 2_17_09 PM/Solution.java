// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String goal) {
        int i=0;
        int j=0;
        int count=0;
        while(i<s.length())
        {
            if(s.charAt(i)==goal.charAt(j))
                {count++;i++;j=(j+1)%s.length();}
            else 
                j=(j+1)%s.length();
        }
        
        return count==s.length();
    }
}