// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts=new int[26];
        for(char c : tasks)
             charCounts[c-'A']++;
        
        Arrays.sort(charCounts);
        
        int maxOccuring=charCounts[25]-1; //Removing the last occuring elemnt
        int idleSpots=maxOccuring*n;
        
        for(int i=24;i>=0;i--)
        {
            idleSpots-=Math.min(charCounts[i],maxOccuring);
        }
        return idleSpots>0?idleSpots+tasks.length:tasks.length;
    }
}