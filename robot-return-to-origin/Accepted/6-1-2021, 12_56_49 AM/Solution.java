// https://leetcode.com/problems/robot-return-to-origin

class Solution {
    public boolean judgeCircle(String moves) {
        int UD = 0, LR = 0;
        for (char a : moves.toCharArray()){
            switch (a) {
                case 'U':
                    UD++;
                    break;
                case 'D':
                    UD--;
                    break;
                case 'L':
                    LR++;
                    break;
                default:
                    LR--;
            }  
        }
        return UD == 0 && LR == 0;
    }
}