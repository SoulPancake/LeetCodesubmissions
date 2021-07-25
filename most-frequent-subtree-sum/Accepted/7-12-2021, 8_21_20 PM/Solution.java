// https://leetcode.com/problems/most-frequent-subtree-sum

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        getSum(root, map);
        
        ArrayList<Integer> al = new ArrayList<>();
        int max = -1;
      
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                al.clear();
                al.add(entry.getKey());
            } else if (entry.getValue() == max) {
                al.add(entry.getKey());
            }
        }
        
        int[] res = new int[al.size()];
        int k = 0;
        for (int i : al) {
            res[k++] = i;
        }
        return res;


    }

    private int getSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int sum = root.val + getSum(root.left, map) + getSum(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}