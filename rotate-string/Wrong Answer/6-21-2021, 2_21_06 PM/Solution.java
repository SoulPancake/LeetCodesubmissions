// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String goal) {
        s+=s;
        return s.contains(goal);
    }
}