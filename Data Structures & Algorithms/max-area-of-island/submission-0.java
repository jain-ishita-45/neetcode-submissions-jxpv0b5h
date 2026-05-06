class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int [][]vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
               
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                     int t=1,t1=0;
                     vis[i][j]=1;
                    t=dfs(vis,grid, i, j);
                    ans=Math.max(t,ans);
                }
            }
        }
        return ans;

    }

    public int dfs(int [][]vis, int [][]grid, int i, int j)
    {
        int y=1;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        for(int x=0;x<4;x++)
        {
             
            int nrow=i+drow[x];
            int ncol=j+dcol[x];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                 y+=dfs(vis,grid,nrow, ncol);
            }
        }
        return y;

    }
}
