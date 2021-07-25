// https://leetcode.com/problems/consecutive-characters

class Solution {
    public int maxPower(String s) {
        int l=0;
        int max=-10000000;
        for(int i=0;i<s.length()-1;i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.charAt(j)==s.charAt(i))
                {
                    l++;
                }else
                {
                    max=Math.max(l,max);
                    l=0;
                }
            }
        }
        
        return max+1;
    }
}