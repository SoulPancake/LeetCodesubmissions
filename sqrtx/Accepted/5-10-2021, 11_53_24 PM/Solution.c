// https://leetcode.com/problems/sqrtx

#include<math.h>

int mySqrt(int x){
   return pow(2, 0.5 * log2(x));
}