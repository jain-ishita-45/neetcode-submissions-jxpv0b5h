class Solution {
    public int trap(int[] heights) {
        if(heights==null || heights.length==0)
        return 0;
        int l=0,r=heights.length-1;
        int leftmax=heights[0],rightmax=heights[heights.length-1];
        int res=0;
        while(l<r)
        {
            if(leftmax<rightmax)
            {
                l++;
                leftmax=Math.max(leftmax,heights[l]);
                res+=leftmax-heights[l];
            }
            else
            {
                r--;
                rightmax=Math.max(rightmax,heights[r]);
                res+=rightmax-heights[r];
            }
        }
        return res;
    }
}
