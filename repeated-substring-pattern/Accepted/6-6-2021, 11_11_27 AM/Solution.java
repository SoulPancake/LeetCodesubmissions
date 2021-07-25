// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String string) {
        return ((string + string).indexOf(string, 1) != string.length());
    }
}