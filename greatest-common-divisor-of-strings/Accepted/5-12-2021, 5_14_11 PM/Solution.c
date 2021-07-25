// https://leetcode.com/problems/greatest-common-divisor-of-strings



#include<string.h>

char * gcdOfStrings(char * str1, char * str2){
    
    int l1=strlen(str1);      // [][][][][]]]][][][[][][][][][][]]
    int l2=strlen(str2);      //  +1 =======
    
     if(l1<l2) 
       return gcdOfStrings(str2,str1);
    
         char* bopa="";
   for(int i=0;i<l2;i++)
   {
       if(str1[i]!=str2[i])
           return bopa;
   }
    if(l1==l2)
        return str2;
    
    return gcdOfStrings(str1+l2,str2);
}