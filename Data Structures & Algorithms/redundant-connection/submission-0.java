class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());
        for(int []e:edges)
        {
            int u=e[0],v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean visit[]=new boolean[n+1];
            if(dfs(u,-1,adj,visit))
            return new int[]{u,v};

        }
        return new int[0];
    }

    boolean dfs(int node, int parent,ArrayList<ArrayList<Integer>> adj, boolean[]visit )
    {
        if(visit[node]) return true;
        visit[node]=true;
        for(int nei:adj.get(node))
        {
            if(nei==parent) continue;
            if(dfs(nei,node,adj,visit))
            return true;
        }
        return false;
    }
}
