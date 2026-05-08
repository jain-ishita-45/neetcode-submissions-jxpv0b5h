class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O' && vis[i][0]==0)
            {
                vis[i][0]=1;
                q.offer(new int[]{i,0});
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0)
            {
                vis[i][m-1]=1;
                q.offer(new int[]{i,m-1});
            }

        }

        for(int j=0;j<m;j++)
        {
            if(board[0][j]=='O' && vis[0][j]==0)
            {
                vis[0][j]=1;
                q.offer(new int[]{0,j});
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==0)
            {
                vis[n-1][j]=1;
                q.offer(new int[]{n-1,j});
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
                if(newr>=0 && newr<n && newc>=0 && newc<m && vis[newr][newc]==0 && board[newr][newc]=='O')
                {
                    vis[newr][newc]=1;
                    q.offer(new int[]{newr,newc});
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }
}
