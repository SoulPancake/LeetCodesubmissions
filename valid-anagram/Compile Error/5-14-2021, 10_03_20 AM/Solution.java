// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        
        int freq1[]=new freq1[26];
        int freq2[]=new freq2[26];
        
        Arrays.fill(freq1,0);
        Arrays.fill(freq2,0);
        
        for(int i=0;i<s.length();i++)
        {
            freq1[s[i]-'a']++;
            freq2[t[i]-'a']++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(freq1[s[i]-'a']!=freq2[t[i]-'a'])
                 return false;
        }
        return true;
    }
}