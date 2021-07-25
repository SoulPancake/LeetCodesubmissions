// https://leetcode.com/problems/reduce-array-size-to-the-half

class Solution {
    public int minSetSize(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for(int c : arr)
            set.add(c);
        
        return set.size()>1?set.size()/2:1;
    }
}