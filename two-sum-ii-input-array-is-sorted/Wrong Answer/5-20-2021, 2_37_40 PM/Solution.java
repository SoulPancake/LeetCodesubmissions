// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] arr=new int[2];
        int k=0;
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]>=target)
            {
                k=i;
                break;
            }
        }
        
        for(int i=0;i<k;i++)
        {
            for(int j=i+1;j<k;j++)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    arr[0]=i+1;
                    arr[1]=j+1;
                }
            }
        }
        
        return arr;
    }
}