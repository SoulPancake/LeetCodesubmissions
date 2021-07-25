// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] nums) {
        return getData(0, nums.length-1, nums);
    }
    
    public int getData(int i, int j,int nums[]){
        
          if(i>=j){
              return nums[i];
           }    
            
            int mid=i+(j-i)/2;
 
        
            if(nums[mid]==nums[j]){
               return Math.min(getData(i, mid-1, nums),getData( mid+1,j, nums)) ;   
            }
            else if(nums[mid]>nums[j]){
                return getData(mid+1, j, nums);
            }else{
                return getData(i, mid, nums);
            }
        }
    }