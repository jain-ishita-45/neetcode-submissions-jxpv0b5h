class Solution {
    public void reverse(int [][]matrix,int i)
    {
        int len=matrix[0].length-1,j=0;
        while(j<=len)
        {
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][len];
            matrix[i][len]=temp;
            len--;
            j++;

        }
    }
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i<j)
                {
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            reverse(matrix,i);
        }
    }
}
