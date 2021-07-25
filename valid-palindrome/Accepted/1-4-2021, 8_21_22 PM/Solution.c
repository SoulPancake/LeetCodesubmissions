// https://leetcode.com/problems/valid-palindrome

static bool isvalid(char c) {
    if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90) || (c >= 48 && c <= 57)) return true;
    return false;
}

bool isPalindrome(char * s) {
    char *begin, *end;

    if (*s == '\0') return true;

    begin = s;
    end = s;

    while (*end) end++;

    while (begin <= end) {
        if (!isvalid(*begin)) { begin++; continue; }
        if (!isvalid(*end)) { end--; continue; }
        if (tolower(*begin++) != tolower(*end--)) return false;
    }

    return true;
}