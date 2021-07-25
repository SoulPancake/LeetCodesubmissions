// https://leetcode.com/problems/number-of-wonderful-substrings

class Solution {
    public long wonderfulSubstrings(String word) {
        long count=0;
        
        for(int i=0;i<word.length();i++)
        {
            for(int j=i+1;j<=word.length();j++)
            {
                if(checkWonderful(word.substring(i,j)))
                    count++;
            }
        }
        
        return count;
    }
    
    private boolean checkWonderful(String s)
    {
        int[] freq=new int[10];
        
        for(int c : s.toCharArray())
        {
            freq[c-'a']++;
        }
        
        int oddCount=0;
        
        for(int i=0;i<10;i++)
            if(freq[i]%2!=0)
                oddCount++;
        
        return oddCount<2;
        
        
    }
}