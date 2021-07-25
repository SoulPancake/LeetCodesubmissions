// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        int longestConsecutiveSequence=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        for(int num : nums)
        {
            if(!set.contains(num-1))
            {  int k=1;
                while(true)
                {if(set.contains(num+k))
                    k++;
                else
                   { longestConsecutiveSequence=Math.max(longestConsecutiveSequence,k);break;}}
                
            }
        }
        
        return longestConsecutiveSequence;
    }
}