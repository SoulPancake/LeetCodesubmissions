// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        
        helper(nums,result,0);
        return result;
    }
    
    private void helper(int[] nums,List<List<Integer>> result,int index)
    {
        if(index==nums.length)
        {
            List<Integer> current=new ArrayList<>();
            
            for(int i=0;i<nums.length;i++)
                current.add(nums[i]);
            
            result.add(current);
            return;
        }
        
        for(int j=index;j<nums.length;j++)
        {
            int temp=nums[j];
            nums[j]=nums[index];
            nums[index]=temp;
            
            helper(nums,result,index+1);
            
            temp=nums[j];
            nums[j]=nums[index];
            nums[index]=temp;
        }
    }
}