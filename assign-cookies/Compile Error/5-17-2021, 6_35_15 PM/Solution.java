// https://leetcode.com/problems/assign-cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
     //greedy question
        
        int contentChildren=0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        int largestCookieIndex=s.length-1;
        int greediestChildIndex=g.length-1;
        
        while(i>=0 && j>=0)
        {
            if(s[j]>=g[i])
            {content++;
              largestCookieIndex--;
              greediestChildIndex--;
            }else{
                i--;
            }
            
        }
        
        return content;
        
        
    }
}