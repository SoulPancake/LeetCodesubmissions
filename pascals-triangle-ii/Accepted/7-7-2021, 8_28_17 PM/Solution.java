// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList();
        ans.add(1);
        if (rowIndex == 0) return ans;
        List<Integer> pre = getRow(rowIndex - 1);
        for (int i = 1; i < rowIndex; i ++) {
            ans.add(pre.get(i - 1) + pre.get(i));
        }
        ans.add(1);
        return ans;
    }
}