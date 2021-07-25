// https://leetcode.com/problems/maximum-erasure-value

class Solution {
    
    //Largest subArray with unique elements
    
    public int maximumUniqueSubarray(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {int sum=0;
            for(int j=i;j<nums.length;j++)
            {sum+=nums[j];
                if(isUnique(nums,i,j))
                    max=Math.max(max,sum);
            }
        }
        return max;
    }
    private boolean isUnique(int[] nums,int i,int j)
    {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int p=i;p<=j;p++)
        {
            map.put(nums[p],map.getOrDefault(nums[p],0)+1);
        }
        
        for(int c : map.values())
        {
            if(c>1)
                return false;
        }
        
        return true;
    }
}