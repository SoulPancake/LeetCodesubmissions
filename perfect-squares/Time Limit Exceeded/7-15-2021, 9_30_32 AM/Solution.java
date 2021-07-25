// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
//         int a=(int)Math.sqrt(n);
//         if(a*a==n)return 1;
        
//         if(n<=3)return n;
        //0 -> 0 No perfect square possible
        //1 -> 1^2
        // 2 -> 1^2+1^2
        //3 -> 1^2+1^2+1^2
        
        
        //Maximum number of perfect squares to get sum==n will be n
        
        return helper(n);
        
        
    }
    
    private int helper(int n)
    {
        int a=(int)Math.sqrt(n);
        if(a*a==n)return 1;
        
        if(n<=3)return n;
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++)
        {
            ans=Math.min(ans,helper(n-i*i));
        }
        return ans+1;
    }
}