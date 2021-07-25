// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters

class Solution {
    public int countGoodSubstrings(String s) {
        int k=3;
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo=0;
        int hi=0;
        while(lo<=hi && hi<s.length()) {
            ch[s.charAt(hi)-'a']++;
            while(ch[s.charAt(hi)-'a'] != 1) {
                ch[s.charAt(lo)-'a']--;
                lo++;
            }
            if(hi-lo+1 == k) {
                set.add(s.substring(lo, hi+1));
                ch[s.charAt(lo)-'a']--;
                lo++;
            }
            hi++;
        }
        
        return set.size();
    }
 
        
}