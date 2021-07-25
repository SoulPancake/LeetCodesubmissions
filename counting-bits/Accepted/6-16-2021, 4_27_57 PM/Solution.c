// https://leetcode.com/problems/counting-bits



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* countBits(int num, int* returnSize){
    *returnSize = ++num;
    int *res = (int*)calloc(num,sizeof(int));
    for(int i=1;i<num;++i){
        res[i] = i&1 ? res[i-1]+1 : res[i>>1]; 
    }
    return res;
}