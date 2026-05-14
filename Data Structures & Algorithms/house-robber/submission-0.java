class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return check(nums.length-1,dp,nums);
    }

    public int check(int i, int []dp, int []nums)
    {
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int take=nums[i]+check(i-2,dp,nums);
        int nt= check(i-1,dp,nums);
        return dp[i]=Math.max(take,nt);
    }
}
