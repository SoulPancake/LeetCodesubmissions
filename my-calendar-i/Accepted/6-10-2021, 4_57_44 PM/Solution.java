// https://leetcode.com/problems/my-calendar-i

class MyCalendar {
        TreeMap<Integer,Integer> calendar;
    public MyCalendar() {
      calendar=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
       //Condition around start time
        //If the start time is less less than the lower entry end time
        
        if(calendar.floorEntry(start)!=null && start<calendar.floorEntry(start).getValue())
            return false;
        
        //Condition around end time
        //end > higher entry start time
        
        if(calendar.ceilingEntry(start)!=null && end>calendar.ceilingEntry(start).getKey())
            return false;
        
        calendar.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */