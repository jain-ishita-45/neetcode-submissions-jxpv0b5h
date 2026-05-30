/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        if(intervals.size()==0 || intervals==null) return true;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++)
        {
            if (end>intervals.get(i).start)
            return false;
            else
            end=intervals.get(i).end;
        }
        return true;
    }
}
