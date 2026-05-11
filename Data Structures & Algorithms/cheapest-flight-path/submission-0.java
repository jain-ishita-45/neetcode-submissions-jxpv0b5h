class Pair{
    int first, sec;
    Pair(int first, int sec)
    {
        this.first=first;
        this.sec=sec;
    }
}

class Tuple
{
    int first, sec,third;
    Tuple(int first, int sec,int third)
    {
        this.first=first;
        this.sec=sec;
        this.third=third;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++)
        adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(0,src,0));
        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        dist[i]=(int)(1e9);
        dist[src]=0;
        while(!q.isEmpty())
        {
            Tuple it=q.poll();
            int stop=it.first;
            int node=it.sec;
            int cost=it.third;
            if(stop>k) continue;
            for(Pair iter:adj.get(node))
            {
                int adjnode=iter.first;
                int x=iter.sec;
                if(x+cost<dist[adjnode] && stop<=k)
                {
                    dist[adjnode]=cost+x;
                    q.add(new Tuple(stop+1,adjnode,cost+x));
                }
            }
        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}
