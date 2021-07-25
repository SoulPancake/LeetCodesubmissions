// https://leetcode.com/problems/maximum-alternating-subsequence-sum

class Solution {
    public long maxAlternatingSum(int[] nums) {
        if(nums.length==1)return (long)nums[0];
        List<Integer> arr=new ArrayList<>();
        for(int c : nums)
            arr.add(c);
        
        return maxPossibleDiff(arr,arr.size());
    }
    private long maxPossibleDiff(List<Integer> arr, int N)
{
     
    // Convert arr[] into 1-based indexing
    arr.add(-1);
 
    // Reverse the array
    Collections.reverse(arr);
 
    // Convert arr[] into 1 based index
    arr.add(-1);
 
    // Reverse the array
    Collections.reverse(arr);
 
    // Stores maximum difference between
    // sum of even and odd indexed elements
    long maxDiff = 0;
 
    // Traverse the array
    for(int i = 1; i <= N; i++)
    {
         
        // If arr.get(i) is local maxima
        if (arr.get(i) > arr.get(i - 1) &&
            arr.get(i) > arr.get(i + 1))
        {
             
            // Update maxDiff
            maxDiff += (long)arr.get(i);
        }
 
        // If arr.get(i) is local minima
        if (arr.get(i) < arr.get(i - 1) &&
            arr.get(i) < arr.get(i + 1))
        {
             
            // Update maxDiff
            maxDiff -= (long)arr.get(i);
        }
    }
   return maxDiff;
}
}