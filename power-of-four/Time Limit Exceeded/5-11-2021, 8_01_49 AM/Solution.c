// https://leetcode.com/problems/power-of-four


#include<math.h>
bool isPowerOfFour(int n){
   for(int i=0;i<n;i++)
       if(n==pow(4,i))
           return true;
    
    return false;
}