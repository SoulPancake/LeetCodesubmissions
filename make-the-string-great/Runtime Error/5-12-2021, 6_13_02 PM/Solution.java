// https://leetcode.com/problems/make-the-string-great

class Solution {
    public String makeGood(String s) {
         for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i)==s.charAt(i+1)+32 || s.charAt(i+1)==s.charAt(i)+32)
             {
                 return makeGood(s.substring(0,i)+s.substring(i+2));
             }
         }
        return s;
    }
}