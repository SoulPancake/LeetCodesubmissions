// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        int b=0;
        for(int i : nums)
            if(Integer.toString(i).length()%2==0)b++;
    return b;
    }
}