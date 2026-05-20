class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        sum+=nums[i];
        if(sum%2!=0) return false;
        Boolean dp[][]=new Boolean[nums.length][sum/2+1];
        return dfs(0,nums,dp,sum/2);
    }

    public boolean dfs(int i, int []nums, Boolean [][]dp, int sum)
    {
        if(sum==0) return true;
        if(i==nums.length || sum<0) return false;
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean nt=dfs(i+1,nums, dp, sum);
        boolean t=dfs(i+1,nums,dp,sum-nums[i]);
        return dp[i][sum]=t||nt;
    }
}
