// https://leetcode.com/problems/circular-array-loop

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        HashSet<Integer> nonCycleIndex = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            boolean isForward = nums[i] >= 0;
            int fast = i, slow = i;
            do {
                slow = findNextIndex(nums, slow, isForward, nonCycleIndex); // move slow one step ahead
                fast = findNextIndex(nums, fast, isForward, nonCycleIndex); // move fast two steps ahead
                if(fast != -1) {
                    fast = findNextIndex(nums, fast, isForward, nonCycleIndex);
                }
            }
            while(slow != -1 && fast != -1 && slow != fast);
            
            if(slow != -1 && slow == fast) {
                return true;
            } else {
                nonCycleIndex.add(i);
            }
        }
        return false;
    }
    
    private int findNextIndex(int[] nums, int i, boolean isForward, Set<Integer> nonCycleIndex) {
        boolean direction = nums[i] >= 0;
        if(direction != isForward) {
            return -1; // if different direction, not meet the requirement
        }
        
        int index = (i + nums[i]) % nums.length;
        index = index < 0 ? index + nums.length: index;
        
        if(nonCycleIndex.contains(index)) {
            return -1; // if we already evaluated such case before and it's not a cycle, return -1 directly.
        }
        
        if(i == index) {
            return -1; // if single element in the cycle, not meet the requirement.
        }
        
        return index;
    }
}

//Cycle should only be in one direction!
//Origin can be any random point in the array!
//Cycle should contain more than one elements 