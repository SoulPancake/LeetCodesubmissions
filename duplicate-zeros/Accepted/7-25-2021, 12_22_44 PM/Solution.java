// https://leetcode.com/problems/duplicate-zeros

class Solution{
    public void duplicateZeros(int[] arr) {
        int index = 0;
        HashMap<Integer,Integer> newArr = new HashMap<>();
        for(int item: arr){
            if(item==0){
                newArr.put(index, item);
                newArr.put(index+1, item);
                index = index+2;
            }else{
                newArr.put(index, item);
                index++;    
            }
        }
    
        for(int i = 0; i<arr.length;i++){
            arr[i] = newArr.get(i);
        }
    }
}