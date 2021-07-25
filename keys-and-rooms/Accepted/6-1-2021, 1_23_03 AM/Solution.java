// https://leetcode.com/problems/keys-and-rooms

class Solution {
    private boolean[] marked;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //This problem translates to given a source node 0, is there a path from 0 to every other node? 
        //In other words, are all the nodes in one connected component?
        marked = new boolean[rooms.size()];
        DFS(rooms, 0);
        
        for (boolean boo : marked)
        {
            if (!boo) return false;
        }
        return true;
    }
    private void DFS(List<List<Integer>> rooms, int v)
    {
        marked[v] = true;
        for (int w : rooms.get(v))
        {
            if (!marked[w])
                DFS(rooms, w);
        }
    }
}