// https://leetcode.com/problems/number-of-matching-subsequences

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int num=0;
        for(int i=0;i<words.length;i++)
        {
            if(isSubsequence(s,words[i]))
                num++;
        }
        return num;
    }
    
    
    private boolean isSubsequence(String parent,String sub)
    {
        if(sub.length()==0)return true;
        if(parent.length()==0)return false;
        
        int i=0;
        int j=0;
        int matchingCount=0;
        while(i<parent.length() && j<sub.length())
        {
            if(parent.charAt(i)==sub.charAt(j))
                {matchingCount++;i++;j++;}
            else
                i++;
        }
        
        return matchingCount==sub.length();
    }
    
}