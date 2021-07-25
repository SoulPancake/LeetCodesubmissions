// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum

class Solution {
    public int numSubarrayBoundedMax(int[] arr, int L, int R) 
    {
        int ans = 0;
        
        int i = 0; 
        int prevValidCount = 0;
        
        for(int j = 0 ; j < arr.length ; j++)
        {
            if(arr[j] < L)
            {
                ans += prevValidCount;
            }
            else if(arr[j] > R)
            {
                i = j + 1;
                prevValidCount = 0;
            }
            else
            {
                ans += (j - i + 1);
                prevValidCount = (j - i + 1);
            }
        }
        return ans;
    }
}