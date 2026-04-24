class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length*matrix[0].length-1;
        
        int n=matrix.length, m=matrix[0].length;
       
   
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target)
            return true;
            else if (matrix[row][col]>target)
            high=high-1;
            else low=low+1;
        }
        return false;
    }
}
