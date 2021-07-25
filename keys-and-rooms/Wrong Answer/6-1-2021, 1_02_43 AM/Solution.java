// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> roomsOpened=new HashSet<>();
        for(int i=0;i<rooms.size();i++)
        {
            for(int j=0;j<rooms.get(i).size();j++)
            {
                roomsOpened.add(rooms.get(i).get(j));
            }
            
        }
        
        for(int i=1;i<rooms.size();i++)
        {
            if(!roomsOpened.contains(i))
                return false;
        }
        return true;
    }
}