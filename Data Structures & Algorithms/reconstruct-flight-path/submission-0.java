class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets)
        {
            String src=ticket.get(0);
            String dst=ticket.get(1);
            if(!adj.containsKey(src))
            adj.put(src,new PriorityQueue<>());
            adj.get(src).offer(dst);
        }
        List<String>res=new ArrayList<>();
        dfs(adj,"JFK",res);
        Collections.reverse(res);
        return res;
    }

    public void dfs(Map<String,PriorityQueue<String>> adj, String src,List<String>res )
    {
        PriorityQueue<String> q=adj.get(src);
        while(q!= null && !q.isEmpty())
        {
            String dst=q.poll();
            dfs(adj,dst,res);
        }
        res.add(src);
    }
}
