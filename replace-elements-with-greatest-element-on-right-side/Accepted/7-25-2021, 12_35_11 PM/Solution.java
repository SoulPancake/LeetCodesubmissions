// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int temp = -1,i = arr.length-1;
        while(i>=0){
            res[i] = temp;
            temp = Math.max(temp,arr[i]);
            i--;
        }
        return res;
    }
}