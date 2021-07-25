// https://leetcode.com/problems/interleaving-string

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);
        return recurse(s1, s2, s3, 0, 0, 0, cache);
    }
    
    boolean recurse(String s1, String s2, String s3, int i, int j, int k, int[][] cache) {
        if(i == s1.length() && j == s2.length()) {
            return true;
        }
        if(cache[i][j] != -1) return cache[i][j] == 1;
        char c = s3.charAt(k);
        boolean ans = false;
        if(i < s1.length() && s1.charAt(i) == c && j < s2.length() && s2.charAt(j) == c) {
            ans = recurse(s1, s2, s3, i+1, j , k+1, cache) 
                || recurse(s1, s2, s3, i, j+1, k+1, cache);
        } else if(i < s1.length() && s1.charAt(i) == c) {
            ans = recurse(s1, s2, s3, i+1, j, k+1, cache);
        } else if(j < s2.length() && s2.charAt(j) == c) {
            ans = recurse(s1, s2, s3, i, j+1, k+1, cache);
        }
        cache[i][j] = ans ? 1 : 0;
        return ans;
    }
}