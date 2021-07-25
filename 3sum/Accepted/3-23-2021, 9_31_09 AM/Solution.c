// https://leetcode.com/problems/3sum

int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){

    printf("SIZE IS %d\n",numsSize);
    quick_sort(nums,0,numsSize-1);
    
    int i,j,k,b[1000000][3],t=0,x,y,temp=0,c=0,p=0;
    
    for(i=0;i<numsSize-2;i++)
    {
   
    j=i+1;
    k=numsSize-1;
        
    if(nums[i]>0&&nums[j]>0&&nums[k]>0)
    break;
        
    while(j<k)
    {
   
    if(nums[i]+nums[j]+nums[k]==0)
    {
    
    if(t==0)
    {
    b[t][0]=nums[i];
    b[t][1]=nums[j];
    b[t][2]=nums[k];
    ++t;
    }
     
    
    else
    {
        c=0;
    for(p=t-1;p>=0;p--)
    {
        if(b[p][0]==nums[i]&&b[p][1]==nums[j]&&b[p][2]==nums[k])
        {
            ++c;
            break;
        }
    }
        
    if(c==0)
    {
    b[t][0]=nums[i];
    b[t][1]=nums[j];
    b[t][2]=nums[k];
    ++t;    
    }
    }

    j++;
    k--;
    }
        
    else if(nums[i]+nums[j]+nums[k]>0)
    k--;    
    else if(nums[i]+nums[j]+nums[k]<0)
    j++;  
    }
        
    }
    
    printf("VALUE OF T IS %d\n",t);
    
    *returnSize =t;
    int **result = (int **)malloc(t * sizeof(int *));
    *returnColumnSizes = (int *)malloc(t * sizeof(int));
    
    for (int i = 0; i <t; i++){
        (*returnColumnSizes)[i] =3;
        
        result[i] =(int *)malloc(3*sizeof(int));
        result[i][0] = b[i][0];
        result[i][1] = b[i][1];
        result[i][2] = b[i][2];
    }   

    
return result;    
}

void quick_sort(int nums[],int f, int l) {
  int i, j, t, p = 0;

  if (f < l) {
    p = f;
    i = f;
    j = l;

    while (i < j) {
      while (nums[i] <= nums[p] && i < l)
        i++;
      while (nums[j] > nums[p])
        j--;
      if (i < j) {
        t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
      }
    }

    t = nums[p];
    nums[p] = nums[j];
    nums[j] = t;
    quick_sort(nums,f, j - 1);
    quick_sort(nums,j + 1, l);
  }
}