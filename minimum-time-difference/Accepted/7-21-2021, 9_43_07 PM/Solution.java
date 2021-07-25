// https://leetcode.com/problems/minimum-time-difference

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeSeen=new boolean[24*60]; //All times of the day 0000 to 2359
        
        for(String time :  timePoints){
            String[] curTime=time.split(":");
            int hours=Integer.parseInt(curTime[0])*60;
            int mins=Integer.parseInt(curTime[1]);
            if(timeSeen[hours+mins]){
                return 0;//Two times same so difference in minutes would be 0
            }
            timeSeen[hours+mins]=true;
        }
        
        Integer firstTimeSeen=null;
        Integer previousTimeSeen=null;
        Integer minimumDifference=Integer.MAX_VALUE;
        
        
        for(int i=0;i<24*60;i++)
        {
            if(timeSeen[i]){
                if(firstTimeSeen==null){
                    firstTimeSeen=i;
                    previousTimeSeen=i;
                }else{
                    minimumDifference=Math.min(minimumDifference,Math.min(i-previousTimeSeen,1440-i+previousTimeSeen));
                    //cloclwise and counter clockwise difference
                    previousTimeSeen=i;
                }
            }
        }
        
         minimumDifference=Math.min(minimumDifference,Math.min(previousTimeSeen-firstTimeSeen,1440-previousTimeSeen+firstTimeSeen));
        
        
        return minimumDifference;
    }
}