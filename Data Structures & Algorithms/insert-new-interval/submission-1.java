class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<intervals.length && intervals[i][1]<newInterval[0])
        {
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int start=newInterval[0],end=newInterval[1];
        while(i<n && intervals[i][0]<=newInterval[1])

        {
            start=Math.min(start,Math.min(intervals[i][0],newInterval[0]));
            end=Math.max(end,Math.max(intervals[i][1],newInterval[1]));
            i++;
        }
        ans.add(new int[]{start,end});
        while(i<n)
        {  ans.add(new int[]{intervals[i][0], intervals[i][1]});
        i++;
        }
        int [][]result=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++)
        {
            result[j]=ans.get(j);
        }
        return result;
    }
}
