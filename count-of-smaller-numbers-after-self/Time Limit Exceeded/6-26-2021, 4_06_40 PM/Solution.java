// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> countSmaller=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++)
        {int count=0;
            for(int j=i+1;j<nums.length;j++)
            {
                
                if(nums[j]<nums[i])
                    count++;
            }
          countSmaller.add(count);
        }
        countSmaller.add(0);
        return countSmaller;
    }
}