// https://leetcode.com/problems/gray-code

class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 1) return new ArrayList<>(Arrays.asList(0,1));
        List<Integer> seq = grayCode(n-1);
        int size = seq.size();
        int mask = 1 << n-1;
        for(int i=size-1; i>=0; i--){
            seq.add(mask | seq.get(i));
        }
        return seq;
    }
}