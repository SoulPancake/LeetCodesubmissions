// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers

class Solution {
    public int minPartitions(String n) {
        char[] c=n.toCharArray();
        int max=Integer.MIN_VALUE;
        for(char cs : c)
        {
            if(cs-'0'>max)
                max=cs-'0';
        }
        return max;
    }
}