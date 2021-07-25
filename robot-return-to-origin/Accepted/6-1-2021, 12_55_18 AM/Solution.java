// https://leetcode.com/problems/robot-return-to-origin

class Solution {
    public boolean judgeCircle(String moves) {
        int L=0;
        int R=0;
        int U=0;
        int D=0;
        
        for(char c : moves.toCharArray())
        {
            if(c=='R')
                 R++;
            else if(c=='L')
                 L++;
            else if(c=='U')
                 U++;
            else
                D++;
        }
        
        return (R==L && U==D);
    }
}