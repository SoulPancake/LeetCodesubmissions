// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        
        while(left<=right)
        { 
            int mid=left+(right-left)/2;
            
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>=nums[left] ) //Left sorted portion e achi
            {
                if(target>nums[mid] || target<=nums[left]) //If target is greater than middle or the target is even lesser than the least value assuming that we are in the left sorted array then we will simply search in the right half
                {
                    left=mid+1;
                }else{ //Less than the middle but greater than the middle so we will search in the left portion
                     right=mid-1;
                }
              
            }
            else{ //Right sorted portion
                if(target<nums[mid] || target>nums[right])
                {
                    right=mid-1;
                }else{ //Target>mid target<right Search only in the right portion of the array
                    left=mid+1;
                }
                
            }   
                 
        }
        
        
        return -1;
    }
}