class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int e[]:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int visited[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                bfs(q,visited,i,adj);
                c++;
            }
            
        }
        return c;
    }

    public void bfs(Queue<Integer>q, int []visited,int i,List<List<Integer>>adj )
    {
        visited[i]=1;
        q.offer(i);
        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int it:adj.get(node))
            {
                if(visited[it]==1) continue;
                q.offer(it);
                visited[it]=1;
            }
        }
    }
}
