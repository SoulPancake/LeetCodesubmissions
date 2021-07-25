// https://leetcode.com/problems/check-if-n-and-its-double-exist



bool checkIfExist(int* arr, int arrSize){
    for(int i=0;i<arrSize;i++)
    {
        for(int j=1;j<arrSize-1;j++)
           {
               if(arr[j]==2*arr[i] || arr[i]==2*arr[j])
                   return true;
           }
     }
    
    return false;
}