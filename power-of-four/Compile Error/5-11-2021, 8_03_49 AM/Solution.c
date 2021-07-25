// https://leetcode.com/problems/power-of-four


#include<math.h>
bool isPowerOfFour(int n){
  if(num==1)
      return true;
   if(num==2 || num==3 )
       return false;
    if(n%4==0)
     return isPowerOfFour(n/4);
    
}