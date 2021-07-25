// https://leetcode.com/problems/longest-substring-without-repeating-characters

int lengthOfLongestSubstring(char * s){
    char *address[128] = {NULL};
    int len =0;
    char *tmp,*start=s; //Assign the first pointer
    while(*start)
    {
        tmp = address[*start]; //Extract value
        address[*start] = start; //Assign the value
        if(tmp >= s)
        {
            len = len > start - s ? len : start - s; //Difference between current pointer and starting pointer
            s = tmp +1; // next starting pointer
        }
        start++;
    }
    len = len > start - s ? len : start -s;
    return len;
}