// https://leetcode.com/problems/valid-anagram

bool isAnagram(char* s, char* t) {
    int table[256];
    memset(table, 0, sizeof(int)*256);
    int sizeS = strlen(s);
    int sizeT = strlen(t);
    if(sizeS != sizeT) return false;
    for (int i = 0; i < sizeS; i++)
    {
        table[s[i]] += 1;
        table[t[i]] -= 1;
    }
    for(int i = 0; i < 128; i++)
    {
        if (table[i] != 0) return false;
    }
    return true;
}