// https://leetcode.com/problems/check-if-n-and-its-double-exist



bool checkIfExist(int* arr, int arrSize){
    for(int i=0;i<arrSize;i++)
    {
        if(arr[i]%2==0 || (-1*arr[i])%2==0)
        {
           for(int j=0;j<arrSize-1;j++)
           {
               if(arr[j]==arr[i]/2)
                   return true;
           }
        }else
        {
            for(int j=0;j<arrSize-1;j++)
            {
                if(arr[j]==2*arr[i])
                    return true;
            }
        }
    
    }
    return false;
}