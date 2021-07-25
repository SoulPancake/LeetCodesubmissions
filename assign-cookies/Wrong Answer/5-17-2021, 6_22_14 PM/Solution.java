// https://leetcode.com/problems/assign-cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int content=0;
        int len=Math.min(g.length,s.length);
        for(int i=0;i<len;i++)
        {
            if(g[i]<=s[i])
                content++;
        }
        return content;
    }
}