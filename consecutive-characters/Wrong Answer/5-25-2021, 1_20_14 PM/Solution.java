// https://leetcode.com/problems/consecutive-characters

class Solution {
    public int maxPower(String s) {
        if(s.length()==1)
            return 1;
        char prev=s.charAt(0);
        int count=1;
        int maxCount=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==prev)
                count++;
            else
                {maxCount=Math.max(count,maxCount);
                 count=1;
                 prev=s.charAt(i);}
        }
        
        return maxCount;
            
    }
}