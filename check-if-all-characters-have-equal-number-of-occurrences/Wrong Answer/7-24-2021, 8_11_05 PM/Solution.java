// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq=new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        int a=freq[0];
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0 && a!=freq[i])
                return false;
        }
        return true;
    }
}