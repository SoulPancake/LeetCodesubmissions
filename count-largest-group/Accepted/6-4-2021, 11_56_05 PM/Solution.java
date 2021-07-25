// https://leetcode.com/problems/count-largest-group

class Solution {
    public int countLargestGroup(int n) {
        int count[] = new int[37];
        for(int i=1; i<=n; ++i){
            if(i > 9){
                int temp = i;
                int sum = 0;
                while(temp != 0){
                    sum += temp%10;
                    temp /= 10;
                }
                count[sum]++;
            }else{
                count[i]++;
            }
        }
        Arrays.sort(count);
        int k = count[count.length-1];
        int res = 0;
        for(int c :count){
            if(c == k){
                res++;
            }
        }
        return res;
    }
}