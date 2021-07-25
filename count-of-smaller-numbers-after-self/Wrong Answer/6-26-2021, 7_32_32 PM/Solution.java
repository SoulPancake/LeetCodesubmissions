// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution { int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        count=new int[nums.length];
        
        int[] originalIndex=new int[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            originalIndex[i]=i; 
         }
        
        
        sort(nums,originalIndex,0,nums.length-1);
        
        for(int i=0;i<nums.length;i++)
            result.add(count[i]);
        
        
        return result;
    }
                
    private void sort(int[] nums,int[] originalIndex,int left,int right)
    {
        if(left<right)
        {
            int mid=left+(right-left)/2;
            sort(nums,originalIndex,left,mid);
            sort(nums,originalIndex,mid+1,right);
            merge(nums,originalIndex,left,mid,right);
        }
    }
                
    private void merge(int[] nums,int[] originalIndex,int left,int mid,int right)
    {
        int leftArraySize=mid-left+1;
        int rightArraySize=right-mid;
        
        int[] leftArray=new int[leftArraySize];
        int[] rightArray=new int[rightArraySize];
        
        for(int i=0;i<leftArraySize;i++)
        {
            leftArray[i]=originalIndex[left+i];
        }
        
        for(int i=0;i<rightArraySize;i++)
        {
            rightArray[i]=originalIndex[i+mid+1];
        }
        
        int i=0,j=0,k=left;//k is left bound
        int rightCount=0;//Number of jumps on the right hand side
        
        while(i<leftArraySize && j<rightArraySize)
        {
            if(nums[leftArray[i]]<=nums[rightArray[j]])
                {originalIndex[k]=leftArray[i];
                count[leftArray[i]]+=rightCount;i++;}
            else{
                originalIndex[k]=rightArray[j];
                rightCount++;
                j++;
            }
            k++;
        }
        
        
        while(i<leftArraySize)
        {      originalIndex[k]=leftArray[i];
                count[leftArray[i]]+=rightCount;i++;
        }
        
        while(j<rightArraySize)
        {
            originalIndex[k]=rightArray[j];
            j++;
            k++;
        }
    }
}