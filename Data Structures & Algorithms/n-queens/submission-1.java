class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char [][]board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            board[i][j]='.';
        }

        nqueen(0,board,result,n);
        return result;
    }

    public void nqueen(int i,char board[][],  List<List<String>> result, int n)
    {
        if(i==n) 
        {
            List<String> ans=new ArrayList<>();
            for(char []row:board)
            ans.add(new String(row));
            result.add(ans);
            return;

        }
        for(int j=0;j<n;j++)
        {
            if(issafe(i,j,board,n))
            {
               board[i][j]='Q';
                nqueen(i+1,board,result,n);
                board[i][j]='.';
            }
        }
    }

    public boolean issafe(int row, int col, char board[][], int n)
    {
        for(int j=0;j<col;j++)
        {
            if(board[row][j]=='Q')
            return false;
        }

        for(int j=0;j<row;j++)
        {
            if(board[j][col]=='Q')
            return false;
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            return false;
        }

        for(int i=row,j=col;i>=0 && j<n;i--,j++)
        {
            if(board[i][j]=='Q')
            return false;
        }
        return true;

    }
}
