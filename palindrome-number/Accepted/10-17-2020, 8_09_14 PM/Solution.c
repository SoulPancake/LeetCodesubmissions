// https://leetcode.com/problems/palindrome-number



bool isPalindrome(int x){
if(x < 0){
return false;
}

char * str = (char *) calloc(16, sizeof(char));

sprintf(str,"%d",x);
int len = strlen(str);

for(int x = 0, y = len - 1; x <= y; x++, y--){
if(str[x] != str[y])
return false;
}

return true;
}