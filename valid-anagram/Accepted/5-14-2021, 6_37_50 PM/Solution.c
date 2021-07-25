// https://leetcode.com/problems/valid-anagram

bool isAnagram(char * s, char * t){
    int len1 = strlen(s), len2 = strlen(t);
    if (len1 != len2) return false;
    int *cs = calloc(26, sizeof(int));
    for (int i = 0; i < len1; i++) {
        int id1 = s[i] - 'a', id2 = t[i] - 'a';
        cs[id1]++;
        cs[id2]--;
    }
    for (int i = 0; i < 26; i++) {
        if (cs[i]!= 0) {
            free(cs);
            return false;
        }
    }
    free(cs);
    return true;
}