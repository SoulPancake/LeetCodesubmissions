// https://leetcode.com/problems/power-of-two



bool isPowerOfTwo(int n){
  if(n==0)
      return false;
  if(n==1)
      return true;
  else if(n%2==0)
     return isPowerOfFour(n/2);
  else 
      return false;
}