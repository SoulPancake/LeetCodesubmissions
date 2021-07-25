// https://leetcode.com/problems/check-if-it-is-a-good-array

class Solution {

public int GCD(int i,int j){
    
    int a = Math.max(i,j);
    int b = Math.min(i,j);
    
    while(true){
        
      if(a%b==0)
          return b;
       
       int temp = b;
        
       b = a%b;
       a = temp; 
    
    }
}
    
    
public boolean isGoodArray(int[] nums) {
    
    int gcd=nums[0];
    
    for(int i=1;i<nums.length;i++){
        gcd = GCD(gcd,nums[i]);
        if(gcd==1)
            break;
    }
    
    return gcd==1;
    
}
}