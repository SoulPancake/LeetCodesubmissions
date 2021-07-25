// https://leetcode.com/problems/maximum-erasure-value

class Solution {
	public int maximumUniqueSubarray(int[] nums) {
		int ans=0;
		int sum=0;
		int j=0;
		HashSet<Integer> set=new HashSet<>();
		
		for(int i=0;i<nums.length;i++){
			int val=nums[i];
			//RELEASE
			if(set.contains(val)){
				while(nums[j]!=val){
					set.remove(nums[j]);
					sum-=nums[j];
					j++;
				}
				j++;
			}
			//EXPAND
			else{
				set.add(nums[i]);
				sum+=nums[i];
			}
			//UPDATE ANSWER
			ans=Math.max(ans,sum);
		}
		return ans;
	}
}