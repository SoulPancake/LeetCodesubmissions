// https://leetcode.com/problems/reverse-string



void reverseString(char* s, int sSize){
int i, n = sSize;
    char temp;
    for (i = 0; i < n/2 ;i ++)
    {
        temp = s[i];
        s[i] = s[n - i - 1];
        s[n - i - 1] = temp;
    }
    return s;
}