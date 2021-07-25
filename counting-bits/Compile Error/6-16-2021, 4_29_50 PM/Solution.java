// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
  int[] ans = new int[n+1];
        for(int i=0; i<=n; i++)ans[i] = Collections.frequency(Arrays.asList((Integer.toBinaryString(i)).split("")) ,"1");
        
        return ans;
}