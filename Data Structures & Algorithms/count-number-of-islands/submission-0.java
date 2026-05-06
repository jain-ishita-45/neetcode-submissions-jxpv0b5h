class Solution {
    public int numIslands(char[][] grid) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int vis[][]=new int[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    dfs(grid,i,j,vis);
                    c++;
                }
            }
        }
        return c;
    }

    public void dfs(char [][] grid, int i, int j, int vis[][])
    {
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};
        for(int x=0;x<4;x++)
        {
            int nrow=i+drow[x];
            int ncol=j+dcol[x];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol]==0 && grid[i][j]-'0'==1)
            {
                vis[nrow][ncol]=1;
                dfs(grid,nrow,ncol,vis);
            }
        }
    }
}
