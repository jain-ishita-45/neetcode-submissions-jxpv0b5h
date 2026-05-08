class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n-1) return false;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int e[]:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<int[]>q=new LinkedList<>();
        HashSet<Integer> vis=new HashSet<>();
        q.offer(new int[]{0,-1});
        vis.add(0);
        while(!q.isEmpty())
        {
            int node=q.peek()[0];
            int parent=q.peek()[1];
            q.poll();
            for(int nei:adj.get(node))
            {
                if(nei==parent)
                continue;
                if(vis.contains(nei))
                return false;
                vis.add(nei);
                q.offer(new int[]{nei,node});
            }
        }
        return vis.size()==n;
    }
}
