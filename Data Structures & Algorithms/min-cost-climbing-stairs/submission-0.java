class Solution {

    public int count(int []dp, int i, int []cost)
    {
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=count(dp,i+1,cost);
        int pick2=count(dp,i+2,cost);
        return dp[i]=cost[i]+Math.min(pick,pick2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(count(dp,0,cost),count(dp,1,cost));
    }
}
