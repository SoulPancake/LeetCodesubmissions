// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        for(int i=1;i<num+1;i++)
        {
            
            if(i*i>num){
                return false;
            }
            if(i*i==num){
                return true;
            }
        }
        
        return false;
    }
}