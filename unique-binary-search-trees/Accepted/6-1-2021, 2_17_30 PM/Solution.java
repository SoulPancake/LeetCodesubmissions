// https://leetcode.com/problems/unique-binary-search-trees

class Solution {
    public int numTrees(int n) {
      int res = 0;
 
        // Base case
        if (n <= 1)
        {
            return 1;
        }
        for (int i = 0; i < n; i++)
        {
            res += numTrees(i)
                * numTrees(n - i - 1);
        }
        return res;
    }
}
//Catalan number