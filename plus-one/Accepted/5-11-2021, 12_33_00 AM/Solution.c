// https://leetcode.com/problems/plus-one



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
 if (!digits) return NULL;
    *returnSize = digitsSize;
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (++digits[i] < 10) { return digits; }
        digits[i] %= 10; // Alternatively, you could do "digits[i] = 0" instead.
    }
    // In case all values are '9's, we append a '0' and set the MSD to '1'.
    // e.g, 99 -> 00 -> 000 -> 100
    digits = realloc(digits, ++(*returnSize) * sizeof(int));
    digits[*returnSize - 1] = 0;
    digits[0] = 1;
    return digits;
}