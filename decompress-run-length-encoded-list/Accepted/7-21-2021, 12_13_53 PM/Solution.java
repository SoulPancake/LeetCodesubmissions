// https://leetcode.com/problems/decompress-run-length-encoded-list

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length-1;i+=2){
            for(int j=nums[i];j>0;j--){
                result.add(nums[i+1]);
            }
        }
        int[] a=new int[result.size()];
        int k=0;
        for(int c: result)
             a[k++]=c;
        return a;
    }
}