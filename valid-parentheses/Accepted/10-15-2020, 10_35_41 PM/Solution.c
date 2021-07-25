// https://leetcode.com/problems/valid-parentheses

int is_open(char c) {
    return c == '(' || c == '[' || c == '{';
}

int is_close(char c) {
    return c == ')' || c == ']' || c == '}';
}

bool isValid(char * s){

    char stack[5000];
    int index = 0;
    
    if (is_close(s[0])) {
        return false;
    }
    for (int i = 0; s[i] != 0; i++) {
        
        if (is_open(s[i])) {
            stack[index] = s[i];
            index++;
        } else {
            if (index == 0) {
                return false;
            }
            if ((s[i]==')' && stack[index-1]=='(') ||
                    (s[i]==']' && stack[index-1]=='[') ||
                    (s[i]=='}' && stack[index-1]=='{')) {
                index--;
                stack[index] == 0;
            } else {
                return false;
            }
        }
    }
    
    if (index != 0) {
        return false;
    }
                
    
    return true;
}