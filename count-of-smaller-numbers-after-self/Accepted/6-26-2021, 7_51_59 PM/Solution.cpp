// https://leetcode.com/problems/count-of-smaller-numbers-after-self

#pragma GCC optimize("Ofast")
static const auto fast = []() {
   std::ios_base::sync_with_stdio(false);
   std::cin.tie(0);
   std::cout.tie(0);
   return 0;
} ();

#define SIZE 20001
// Least Significant Bit of i
#define LSB(i) ((i) & -(i))

class Solution {
private:
    int tree_[SIZE];
public:
    // Returns the sum of the first i elements (indices 0 to i)
    // Equivalent to range_sum(0, i)
    int prefix_sum(int i)
    {
        int sum = this->tree_[0];
        for (; i != 0; i -= LSB(i))
            sum += this->tree_[i];
        return sum;
    }

    // Add 1 to element with index i (zero-based)
    void add(int i)
    {
        if (i == 0){
            this->tree_[0] += 1;
            return;
        }
        for (; i < SIZE; i+= LSB(i))
            this->tree_[i] += 1;
    }
    
    vector<int> countSmaller(vector<int>& nums) {
        auto len = nums.size();
        memset(this->tree_,0,SIZE*sizeof(int));
        vector<int> counts(len);
        while (len--) {
            auto x = nums[len]+10001;
            counts[len] = this->prefix_sum(x-1);
            this->add(x);
        }
        return counts;
    }
};