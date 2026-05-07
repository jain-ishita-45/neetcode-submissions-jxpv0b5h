class Solution {
    public void islandsAndTreasure(int[][] grid) {
        final int INF=2147483647;
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                q.offer(new int[]{i,j});
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            int r=q.peek()[0];
            int c=q.peek()[1];
            q.poll();
            for(int i=0;i<4;i++)
            {
                int newr=r+drow[i];
                int newc=c+dcol[i];
                if(newr>=0 && newc>=0 && newr<grid.length && newc<grid[0].length && grid[newr][newc]==INF)
                {
                    q.add(new int[]{newr,newc});
                    grid[newr][newc]=grid[r][c]+1;
                }
            }
        }
    }
}
