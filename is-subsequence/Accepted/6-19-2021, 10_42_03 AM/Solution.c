// https://leetcode.com/problems/is-subsequence


#include<string.h>
bool isSubsequence(char * s, char * t){
     int n=strlen(s);
     int m=strlen(t);
     int j=0;
     if(n==0)return true;
     if(m==0)return false;
     for(int i=0;i<m;i++)
     {
         if(j<n && s[j]==t[i])
             j++;
     }
    
    return j==n?true:false;
}