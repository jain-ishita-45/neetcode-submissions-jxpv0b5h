class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length,node=0;
        int []dist=new int[n];
        boolean[] visit=new boolean[n];
        Arrays.fill(dist,100000000);
        int edges=0,res=0;
        while(edges<n-1)
        {
            visit[node]=true;
            int nextnode=-1;
            for(int i=0;i<n;i++)
            {
                if(visit[i]) continue;
                int curd=Math.abs(points[i][0]-points[node][0])+Math.abs(points[i][1]-points[node][1]);
                dist[i]=Math.min(dist[i],curd);
                if(nextnode==-1 || dist[i]<dist[nextnode])
                nextnode=i;
            }
            res+=dist[nextnode];
            node=nextnode;
            edges++;
        }
        return res;
    }
}
