// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String Longboi="";
        
        if(strs==null || strs.length==0)
            return Longboi;
        
        int index=0;
        
        for(char c : strs[0].toCharArray())
        {
            for(int i=1;i<strs.length;i++)
            {
                if(i>=strs[i].length() || c!=strs[i].charAt(index))
                    return Longboi;
            }
            
         Longboi+=c;
         index++;
        }
        
        return Longboi;
    }
}