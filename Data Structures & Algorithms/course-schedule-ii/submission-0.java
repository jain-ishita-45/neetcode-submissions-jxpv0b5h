class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<numCourses;i++)
       adj.add(new ArrayList<>());
       for(int e[]:prerequisites)
       {
        adj.get(e[1]).add(e[0]);
       } 
       int []indegree=new int[numCourses];
       for(int i=0;i<numCourses;i++)
       {
        for(int e:adj.get(i))
        indegree[e]++;
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<numCourses;i++)
       {
        if(indegree[i]==0)
        q.add(i);
       }
       ArrayList<Integer> ans=new ArrayList<>();
       while(!q.isEmpty())
       {
        int node=q.poll();
        ans.add(node);
        for(int it:adj.get(node))
        {
            indegree[it]--;
            if(indegree[it]==0)
            q.add(it);
        }
       }
       int topo[]=new int[numCourses];
        if(ans.size()==numCourses)
       {
        
        for(int i=0;i<numCourses;i++)
        topo[i]=ans.get(i);
        return topo;
       }
       else
       return new int[]{};
    }
}
