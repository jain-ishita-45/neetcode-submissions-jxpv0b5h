class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q=new LinkedList<>();
        int vis[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                        q.add(new int[]{i,j,0});
                        vis[i][j]=1;

                }
                
            }
        }
        int t=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};
    
            while(!q.isEmpty())
            {
                int r=q.peek()[0];
                int c=q.peek()[1];
                int time=q.peek()[2];
                
                q.poll();
                t=Math.max(t,time);
                time++;
                for(int i=0;i<4;i++)
                {
                    int newr=r+drow[i];
                    int newc=c+dcol[i];
                    if(newr>=0 && newc>=0 && newr<grid.length && newc<grid[0].length && vis[newr][newc]==0 && grid[newr][newc]==1)
                    {
                        vis[newr][newc]=1;
                        q.add(new int[]{newr,newc,time});
                    }
                }
            }
        

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0 )
                return -1;
            }
        }
        return t;
    }
}
