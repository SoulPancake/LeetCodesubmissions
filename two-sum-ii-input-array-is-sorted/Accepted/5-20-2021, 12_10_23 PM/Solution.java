// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] arr=new int[2];
        int k=0;
        for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    arr[k++]=i+1;
                    arr[k]=j+1;
                    break;
                }
            }
        }
        
        return arr;
    }
}