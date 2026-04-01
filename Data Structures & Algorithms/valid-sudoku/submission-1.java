class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length, m=board[0].length;
        
        for(int i=0; i<n;i++)
        { boolean row []=new boolean [10];
            for(int j=0;j<m;j++)
            {
                char ch=board[i][j];
                if (ch=='.') continue;
                if (row[ch-'0']==true)
                {
                      System.out.println("duplicate in row "+i);
                         return false;
                }
               
                row[ch-'0']=true;
                
            }
        }
       
        for(int j=0; j<n;j++)
        {  boolean col[]=new boolean[10];
            for(int i=0;i<m;i++)
            {
                char ch=board[i][j];
                if (ch=='.') continue;
                if (col[ch-'0']==true)
                {
                    System.out.println("duplicate in col "+j);
                    return false;
                }
                
                col[ch-'0']=true;
            }
        }

       
        for (int i=0;i<n;i++)
        {
              for (int j=0;j<m;j++)
              {
                 boolean col1[]=new boolean[10];
                  if(i%3==0 && j%3==0)
                  {
                      for(int k=i;k<i+3;k++)
                      {
                          for(int l=j;l<3+j;l++)
                          {
                              char ch=board[k][l];
                  if (ch=='.') continue;
                  if (col1[ch-'0']==true)
                  {
                       System.out.println("duplicate in row and col "+" "+k+" "+l);
                         return false;
                  }
                 
                  col1[ch-'0']=true;
                          }
                      }
                  }
              }
          }

        return true;
    }
}
