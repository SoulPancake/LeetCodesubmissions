// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) {
            return true;
        }
        int axis = 0;
        double slope1 = 0;
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1]; 
        slope1 = y2 - y1;
        if(slope1 == 0)
            axis = 0;
        slope1 = x2 - x1 != 0 ? slope1 / (x2 - x1) : 0;
        axis = x2 - x1 == 0 ? 1 : 0;
        for(int i = 1; i < coordinates.length-1; i++) {
            x1 = coordinates[i][0];
            y1 = coordinates[i][1];
            x2 = coordinates[i+1][0];
            y2 = coordinates[i+1][1]; 
            int axis2 = 0;
            double slope = y2 - y1;
            if(slope == 0)
                axis2 = 0;
            slope = x2 - x1 != 0 ? slope / (x2- x1) : 0;
            axis2 = x2 - x1 == 0 ? 1 : 0;
            if(axis != axis2)
                return false;
            if(slope1 != slope)
                return false;
        }
        return true;
       
    }
}