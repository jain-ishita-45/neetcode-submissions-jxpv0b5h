class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {if( check(i,j,0,board,word))
            return true;
            }
        }
        return false;
    }

    public boolean check(int i, int j, int k, char[][]board, String word)
    {
        if(k==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(k))
        return false;
        
       
        char temp=board[i][j];
        board[i][j]='#';   
        boolean res=check(i,j+1,k+1,board,word)|| check(i,j-1,k+1,board,word)||  check(i+1,j,k+1,board,word)|| check(i-1,j,k+1,board,word);
                
        board[i][j]=temp;
        return res;
        
    }
}
