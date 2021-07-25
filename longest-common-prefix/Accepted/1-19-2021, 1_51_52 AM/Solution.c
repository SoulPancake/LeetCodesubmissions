// https://leetcode.com/problems/longest-common-prefix



char * longestCommonPrefix(char ** strs, int strsSize){
char *currentPrefix = "";
    int currentPrefixLength;
    for (int i = 0; i < strsSize; i++) {
        int strLen = strlen(strs[i]);
        char *str = strs[i];
        if (i == 0) {
            currentPrefix = malloc(sizeof(char)*(strLen+1));
            currentPrefixLength = strLen;
            strcpy(currentPrefix,str);
        }
        else {
            for (int k = 0; k < strLen + 1; k++) {
                    if (currentPrefix[k] != str[k]) {
                        str[k] = 0;
                        strcpy(currentPrefix,str);
                        currentPrefixLength = strLen + 1;
                        break;
                    }
            }
        }
    }
    return currentPrefix;
}