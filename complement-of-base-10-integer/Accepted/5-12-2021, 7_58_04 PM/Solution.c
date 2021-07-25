// https://leetcode.com/problems/complement-of-base-10-integer



int bitwiseComplement(int N){
unsigned a = ~N, n = sizeof N * CHAR_BIT, b = n;
    for (size_t c = 0 ; N ; b = n - ++c, N >>= 1);
    return b < n ? a << b >> b : 1;
}