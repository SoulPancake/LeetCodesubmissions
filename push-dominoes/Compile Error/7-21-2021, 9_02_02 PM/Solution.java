// https://leetcode.com/problems/push-dominoes

class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        int[] left=new int[n];
        int nearestLeft=-1; //Nearest left force
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                nearestLeft=i;
            }else if(dominoes.charAt(i)=='R'){
                nearestLeft=-1;//Force nullified
            }
            left[i]=nearestLeft;
        }
        
        int[] right=new int[n];
        int nearestRight=-1;
        
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R'){
                nearestRight=i;
            }else if(dominoes.charAt(i)=='L'){
                nearestRight=-1;//Force nullified
            }
            right[i]=nearestRight;
        }
       
        StringBuilder s=new StringBuilder();
        for(int i=0;i<n;i++){
            
            if(dominoes.charAt(i)=='.')
            {int nearestLeftIndex=Left[i];
            int nearestRightIndex=Right[i];
            
            int leftDistance=nearestLeftIndex==-1?Integer.MAX_VALUE:Math.abs(nearestLeftIndex-i);
            int rightDistance=nearestRightIndex==-1?Integer.MAX_VALUE:Math.abs(nearestRightIndex-i);
            
            
            if(leftDistance==rightDistance){
                s.append('.');
            }else if(leftDistance<rightDistance){
                s.append('L');
            }else s.append('R');}else{
                s.append(dominoes.charAt(i));
            }
        }
        
        return s.toString();
    }
}