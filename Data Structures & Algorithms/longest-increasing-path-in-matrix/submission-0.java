class Solution {
      int [][]directions={{-1,0},{0,-1},{1,0},{0,1}};
        int[][]dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp=new int[matrix.length+1][matrix[0].length+1];
      int rows=matrix.length,cols=matrix[0].length;
      for(int []r:dp)
      Arrays.fill(r,-1);
      int lip=0;
      for (int r=0;r<rows;r++)
      {
        for(int c=0;c<cols;c++ )
        {
            lip=Math.max(lip,dfs(r,c,matrix,Integer.MIN_VALUE));
        }
      }
      return lip;

        

        
    }
    int dfs(int r, int c, int matrix[][], int p)
        {
            int rows=matrix.length,col=matrix[0].length;
            if(r<0 || r>=rows || c<0 || c>=col|| matrix[r][c]<=p) return 0;
            int res=1;
            if(dp[r][c]!=-1) return dp[r][c];
            for(int d[]:directions)
            res=Math.max(res,1+dfs(r+d[0],c+d[1],matrix,matrix[r][c]));
            return dp[r][c]=res;
        }
}
