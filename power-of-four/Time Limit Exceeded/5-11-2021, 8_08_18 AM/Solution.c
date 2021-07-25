// https://leetcode.com/problems/power-of-four


#include<math.h>
bool isPowerOfFour(int n){
  if(n==1)
      return true;
  else if(n==2 || n==3 )
       return false;
  else if(n%4==0)
     return isPowerOfFour(n/4);
  else 
      return false;
    
}