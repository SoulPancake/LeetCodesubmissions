// https://leetcode.com/problems/excel-sheet-column-number



int titleToNumber(char * columnTitle){
   int length=sizeof(columnTitle)/sizeof(columnTitle[0]);
    int result=0;
    for(int i=0;i<length;i++)
    {
        result*=26;
        result+=columnTitle[i]-'A'+1;
    }
    return result;
}
