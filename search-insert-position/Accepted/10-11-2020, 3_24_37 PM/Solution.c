// https://leetcode.com/problems/search-insert-position



int searchInsert(int* nums, int numsSize, int target){
 int *Iter = nums;
    int *End = nums + numsSize;
    
    for (int I = 0; Iter != End; I++, Iter++) {
        if (*Iter >= target) {
            return I;
        }
    }
    
    return numsSize;
}