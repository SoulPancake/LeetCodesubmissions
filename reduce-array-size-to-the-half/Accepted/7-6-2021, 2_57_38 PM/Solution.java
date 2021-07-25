// https://leetcode.com/problems/reduce-array-size-to-the-half

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)-> b.compareTo(a));
        int last = arr[0],count = 1,need = arr.length/2,cur = arr.length,res = 0;
        
        //initialize and create frequency map
        for(int i = 1;i<arr.length;i++){
            if(last != arr[i]){
                map.put(last,map.getOrDefault(last,0) + count);
                count = 1;
                last = arr[i];
            }else{
                count++;
            }
        }
        map.put(last,map.getOrDefault(last,0) + count);
        
        //Create Heap
        for(int i : map.keySet()){
            max.add(map.get(i));
        }
		
        //remove elements from heap and subtract from arr.length until we get half of the length.
		//each freq removed from heap represent an element so increment result by 1
        while(cur > need){
            res++;
            cur -= max.poll();
        }
        
        return res;
    }
}