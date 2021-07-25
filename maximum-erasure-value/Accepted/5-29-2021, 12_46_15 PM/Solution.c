// https://leetcode.com/problems/maximum-erasure-value



int maximumUniqueSubarray(int* nums, int numsSize){
    int* hash=(int *)calloc(10001,sizeof(int));
int r = 0, len = numsSize, l = 0, max = 0, sum = 0, cnt = 0;
        while(r < len) {
            sum += nums[r];
			// cnt > 0 means some number is duplicated
            if(hash[nums[r++]]++ >= 1) cnt++;
            while(cnt > 0) {
				// find the leftmost index that no duplicated numbers betwen [l, r]
                sum -= nums[l];
                if(hash[nums[l++]]-- == 2) cnt--;                
            }
            max = max>sum?max:sum;
        }
    free(hash);
        return max;
}

