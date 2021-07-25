// https://leetcode.com/problems/count-number-of-nice-subarrays

Class Solution{
public int numberOfSubarrays(int[] nums, int k) {
         //Replace all odd by 1 and even by 0
        for(int i=0;i<nums.length;i++){
            nums[i] = (nums[i] %2 == 0) ? 0 : 1;
        }
        
        //problem becomes number of subarrays with sum = k
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;//cumulative sum
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum - k)){
                res+=map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}   