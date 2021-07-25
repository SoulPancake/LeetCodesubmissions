// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(char c : tasks)
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        //Frequency of characters
        
        PriorityQueue<Integer> MaxHeap=new PriorityQueue<>((a,b)->b-a);
        
        MaxHeap.addAll(map.values());
        
        int cycles=0;
        while(!MaxHeap.isEmpty())
        {
            List<Integer> temp=new ArrayList<>();
            
            for(int i=0;i<n+1;i++)
            {
                if(!MaxHeap.isEmpty())
                    temp.add(MaxHeap.remove());
            }
            
            for(int i : temp)
            {
                if(--i>0)
                {
                    MaxHeap.add(i);
                }
            }
            
            cycles+= MaxHeap.isEmpty()?temp.size():n+1;
        }
        
        return cycles;
    }
}