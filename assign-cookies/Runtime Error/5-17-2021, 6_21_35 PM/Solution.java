// https://leetcode.com/problems/assign-cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int content=0;
        
        for(int i=0;i<s.length;i++)
        {
            if(g[i]<=s[i])
                content++;
        }
        return content;
    }
}