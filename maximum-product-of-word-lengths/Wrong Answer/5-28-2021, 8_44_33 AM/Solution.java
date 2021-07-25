// https://leetcode.com/problems/maximum-product-of-word-lengths

class Solution {
    public int maxProduct(String[] words) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<words.length-1;i++)
        {
            for(int j=0;j<words.length;j++)
            {
                if(NoCommonLetters(words[i],words[j]) )
                    max=Math.max(words[i].length()*words[j].length(),max);
            }
        }
        return max;
    }
    
    private boolean NoCommonLetters(String s1,String s2)
    {
        for(int i=0;i<s1.length();i++)
        {
            for(int j=0;j<s2.length();j++)
            {
                if(s1.charAt(i)==s2.charAt(j))
                     return false;
            }
        }
      return true;
    }
}