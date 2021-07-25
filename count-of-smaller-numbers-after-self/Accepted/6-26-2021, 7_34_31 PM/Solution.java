// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    private int[] bit;
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        bit = new int[max - min + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(sum(nums[i] - min));
            add(nums[i] - min + 1);
        }
        Collections.reverse(res);
        return res;
    }
    
    private int lowbit(int i) {
        return i & -i;
    }
    
    private int sum(int k) {
        int sum = 0;
        for (; k > 0; k -= lowbit(k)) {
            sum += bit[k];
        }
        return sum;
    }
    
    private void add(int k) {
        for (; k < bit.length; k += lowbit(k)) {
            bit[k]++;
        }
    }
}