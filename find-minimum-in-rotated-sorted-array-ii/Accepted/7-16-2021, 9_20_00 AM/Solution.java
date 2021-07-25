// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] a) {
        int l = 0;
        int h = a.length-1;
        int min = Integer.MAX_VALUE;
        while(l <= h) {
            int m = (l+h)/2;
            min = Math.min(min, a[m]);
            if(a[h] < a[m]) {
                l = m+1;
            }
            else {
                while(l <= h && a[l] == a[h]) {
                    l++;
                    h--;
                }
                if(l > h) {
                    break;
                }
                if(a[h] < a[m]) {
                    l = m+1;
                }
                else {
                    h = m-1;
                }
            }
        }
        return min;
    }
}