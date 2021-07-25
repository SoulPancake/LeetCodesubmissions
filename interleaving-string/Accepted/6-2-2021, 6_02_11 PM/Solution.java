// https://leetcode.com/problems/interleaving-string

class Solution {
public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            dp[i+1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        
        for (int i = 0; i < n; i++) {
            dp[0][i+1] = dp[0][i] && s2.charAt(i) == s3.charAt(i);
        }
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i * j == 0) continue;
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) dp[i][j] = dp[i][j] || dp[i - 1][j];
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}