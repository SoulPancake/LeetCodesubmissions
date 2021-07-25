// https://leetcode.com/problems/check-if-it-is-a-good-array

class Solution {
    public boolean isGoodArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(gcd(nums[i],nums[j])==1)
                    return true;
            }
        }
        return false;
    }
     private int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
}