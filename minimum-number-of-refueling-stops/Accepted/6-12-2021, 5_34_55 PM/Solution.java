// https://leetcode.com/problems/minimum-number-of-refueling-stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target)return 0;
        
        int xCurrent=startFuel; //max coordinate you can reach with intitial fuel!
        int noOfStopsNeeded=0;
        
        PriorityQueue<Integer> maxAvailableFuel=new PriorityQueue<>((a,b)->(b-a));//Max heap
        
        
      for(int[] station : stations)
      {
          int nextStationX=station[0];
          int fuelAtStation=station[1];
          
          while(xCurrent<nextStationX)//Exhausted All your fuel
          {
              if(maxAvailableFuel.isEmpty())
                  return -1;
              
              xCurrent+=maxAvailableFuel.poll();
              noOfStopsNeeded++;
          }
          maxAvailableFuel.offer(fuelAtStation);
      }
        
        while(xCurrent<target)
        {
             if(maxAvailableFuel.isEmpty())
                  return -1;
              
              xCurrent+=maxAvailableFuel.poll();
              noOfStopsNeeded++;
        }
        
        return noOfStopsNeeded;
    }
}