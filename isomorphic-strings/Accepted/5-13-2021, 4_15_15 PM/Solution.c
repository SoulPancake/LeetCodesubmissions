// https://leetcode.com/problems/isomorphic-strings

bool isIsomorphic(char* s, char* t) {
char vektorarlps[256] = { 0 };
char vektoralpt[256] = { 0 };
int i = 0;
while (s[i] !=0)
{
if (vektorarlps[s[i]] == 0 && vektoralpt[t[i]] == 0)
{
vektorarlps[s[i]] = t[i];
vektoralpt[t[i]] = s[i];
}
else if (vektorarlps[s[i]] != t[i] || vektoralpt[t[i]] != s[i])
return false;
i++;
}

return true;
}