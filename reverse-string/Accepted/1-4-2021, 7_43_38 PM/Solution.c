// https://leetcode.com/problems/reverse-string



void reverseString(char* s, int sSize){
   
    int t;
    for(int i=0;i<(sSize/2);i++)
    {
        t=s[i];
        s[i]=s[sSize-i-1];
        s[sSize-i-1]=t;
    }
}