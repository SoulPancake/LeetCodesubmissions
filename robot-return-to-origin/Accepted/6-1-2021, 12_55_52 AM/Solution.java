// https://leetcode.com/problems/robot-return-to-origin

class Solution {
    public boolean judgeCircle(String moves) {
        int u =0;
        int l=0;
        int r = 0;
        int d = 0;
        for(char c : moves.toCharArray()) {
            if(c == 'U') u++;
            else if(c == 'D') d++;
            else if(c == 'R') r++;
            else if (c=='L') l++;
        }
        if(u == d  && l == r)
            return true;
        return false;
    }
}