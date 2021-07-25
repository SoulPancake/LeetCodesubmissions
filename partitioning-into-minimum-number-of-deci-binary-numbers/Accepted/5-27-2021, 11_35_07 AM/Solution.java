// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers

class Solution {
    public int minPartitions(String n) {
        int max=Integer.MIN_VALUE;
        for(char c : n.toCharArray())
        {
            if(c-'0'>max)
                max=c-'0';
        }
        return max;
    }
}