// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        
        if(l1<l2)
            return gcdOfStrings(str2,str1);
        
        String bopa="";
        for(int i=0;i<l2;i++)
        {
            if(str1.charAt(i)!=str2.charAt(i))
                return bopa;
                
        }
        
        if(l1==l2)
           return str2;
        
        return gcdOfStrings(str1.substring(l2),str2);
        
    }
}