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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b)->a.start-b.start);
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(Interval interval:intervals)
        {
            if(!minheap.isEmpty() && minheap.peek()<=interval.start)
            minheap.poll();
            minheap.offer(interval.end);
        }
        return minheap.size();
    }
}
