class Pair{
    int l1,l2;
    Pair(int l1,int l2)
    {
        this.l1=l1;
        this.l2=l2;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());
        for(int t[]:times)
        {
            int u=t[0];
            int v=t[1];
            int time=t[2];
            adj.get(u).add(new Pair(v,time));
            
        }

        int time[]=new int[n+1];
        for(int i=1;i<=n;i++)
        time[i]=100000;
        time[k]=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(k,0));
        while(!q.isEmpty())
        {
            Pair node=q.poll();
            int u=node.l1;
            int d=node.l2;
            for(Pair it:adj.get(u))
            {
                int v=it.l1;
                int wt=it.l2;
                if(d+wt<time[v])
                {
                    time[v]=d+wt;
                    q.offer(new Pair(v,time[v]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            if(time[i]==100000)
            return -1;
            max=Math.max(max,time[i]);
        }
        return max;
    }
}
