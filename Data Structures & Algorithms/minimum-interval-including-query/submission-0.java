class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int []output=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        output[i]=1000;
        for(int j=0;j<queries.length;j++)
        {
            for(int i=0;i<intervals.length;i++)
            {
               
                if(intervals[i][0]<=queries[j] && queries[j]<=intervals[i][1])
                {
                    output[j]=Math.min(intervals[i][1]-intervals[i][0]+1,output[j]);
            

                }
              

            }
            if(output[j]==1000) output[j]=-1;
        }
        return output;
    }
}
