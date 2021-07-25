// https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing

class Solution {
    public boolean canBeIncreasing(int[] nums) {
      if(checkIncreasing(nums,-1))return true;
          
        for(int i=0;i<nums.length;i++)
        {
            
             if(checkIncreasing(nums,i))
                  return true;;
            
        }
        
        return false;
        
}
    
    private boolean checkIncreasing(int[] nums,int exclude)
    {
        if(exclude==-1)
        {
            int count=0;
            for(int i=1;i<nums.length;i++)
            {
                 if(nums[i]>nums[i-1])
                     count++;
            }
            return count==nums.length-1;
        }
        
        
        int[] array=new int[nums.length-1];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i!=exclude)
                array[k++]=nums[i];
        }
        
       return checkIncreasing(array,-1);
    }
    
    
}