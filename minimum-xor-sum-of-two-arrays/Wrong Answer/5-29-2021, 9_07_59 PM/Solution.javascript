// https://leetcode.com/problems/minimum-xor-sum-of-two-arrays

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minimumXORSum = function(nums1, nums2) {
    let remaining=new Array(nums2.length).fill(1);
    return dp(0,remaining);
    
    function dp(i,remain)
    {
        if(i==nums2.length)
            return 0;
    
    let best=+Infinity;
    
    for(let j=0;j<remain.length;j++)
        {
            if(remain[j]==0)continue;
            remain[j]=0;
            best=Math.min(best,(nums1[i]^nums2[j])+dp(i+1,remain));
        }
        return best;
    }        
};