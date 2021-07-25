// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers

class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        for(int i=1;i<n;i++)
        {
            if(noZeroes(i) && noZeroes(n-i))
                return new int[] {i,n-i};
        }
        return new int[]{-1};
    }
    
    private boolean noZeroes(int n)
    {
        int product=1;
        
        while(n>0)
        {
            product*=n%10;
            n/=10;
        }
        return product!=0;
    }
        
}