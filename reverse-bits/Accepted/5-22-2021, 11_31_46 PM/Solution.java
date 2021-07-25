// https://leetcode.com/problems/reverse-bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int shift = 31;
	int r = 0;
	for(int i = 0; i < 32; ++i, n >>= 1, --shift){
		r = r ^ ((n & 1) << shift);
	}
	return r;
    }
}