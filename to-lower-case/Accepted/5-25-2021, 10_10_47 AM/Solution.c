// https://leetcode.com/problems/to-lower-case

#include<string.h>

char * toLowerCase(char * s){
    
    for(int i=0;i<strlen(s);i++)
    {
        if(s[i]>=65  && s[i]<=90) //That character is capital
            s[i]+=32;       
    }
    return s;
}