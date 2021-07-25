// https://leetcode.com/problems/count-number-of-nice-subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        int last = -1, count = 0;
        for(int i=0; i<nums.length; i++){
        
            if(nums[i]%2 == 1)
                window.addLast(i);
            
            if(window.size() > k)
                last = window.removeFirst();
            
            if(window.size() == k ){
                count += window.peekFirst() - last;
            }
            
        }
        return count;
    }
}