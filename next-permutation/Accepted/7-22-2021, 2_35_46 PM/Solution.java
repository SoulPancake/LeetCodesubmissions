// https://leetcode.com/problems/next-permutation

 class Solution 
{
//eg:  a[6]={1, 2, 3 ,7 ,5, 0}
    public void nextPermutation(int[] nums) 
    {
	   int i = nums.length - 2;   
        while (i >= 0 && nums[i + 1] <= nums[i]) 
        {
		   i--;
        }
        //  i=4
		// for i=4 , a[5]<= a[4] -->{0<=5}  condition true , so now i=3
		// for i=3 , a[4]<= a[3] -->{5<=7}  condition true, so now i=2
		// for i=2 , a[3]<= a[2] -->{7<=3}  condition failed, 
		// so now i=2
		//i=2>0
        if (i >= 0) 
        {
            int j = nums.length - 1; 
			//here i=2,j=4 
			//a[5]<=a[2]--->{5<=3} condition false, so we swap (5,3)
			// 1 2 5 7 3 0
			while (nums[j] <= nums[i]) 
            {
                j--;
            }
            swap(nums, i, j);
        }
		//here i=2
        reverse(nums, i + 1);
    }
    private void reverse(int[] nums, int start) 
    {
	    //i=3
        int i = start, j = nums.length - 1;
		while (i < j) // 3<5
		{
		// 1 2 5 7 3 0
            swap(nums, i, j);
		// swap(7,0)
		// 1 2 5 0 3 7
            i++;// 4
            j--;// 4
		
        }
		// hence, 1 2 5 0 3 7 **
    }
   private void swap(int[] nums, int i, int j) 
   {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}