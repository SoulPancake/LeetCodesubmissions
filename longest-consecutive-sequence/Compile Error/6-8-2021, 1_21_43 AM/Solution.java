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
            { int currentNum=num;
              int currentStreak=1;
             
               while(set.contains(currentNum+1))
                   currentNum++;
                   currentStreak++;
            }
            longestConsecutiveSequence=Math.max(longestConsecutiveSequence,currentStreak);
        }
        
        return longestConsecutiveSequence;
    }
}