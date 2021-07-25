// https://leetcode.com/problems/consecutive-numbers-sum

class Solution {
    public int consecutiveNumbersSum(int n) {
      int res=0;
        
        for(int i=1;i*(i-1)/2<n;i++)
        {
            if((n-i*(i-1)/2)%i==0)
                res++;
        }
        
        return res;
    }
}



//         int[] dp=new int[n+1];
        
//         dp[0]=0;
//         if(n<=1)return 1;
//         dp[1]=1;
        
//         dp[2]=1;
//         dp[3]=2; //3  1+2 
//         dp[4]=1;    // 4 
//         dp[5]=2;
//         dp[6]=   //5   2+3