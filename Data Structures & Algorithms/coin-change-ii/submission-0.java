class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp=new int[coins.length][amount+1];
        for(int r[]:dp) Arrays.fill(r,-1);
        return check(coins,dp,0,amount);
    }

    public int check(int []coins, int [][]dp, int i, int amount)
    {
        if(amount==0) return 1;
        if(i>=coins.length) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take=0;
        if(amount>=coins[i]) take=check(coins,dp,i,amount-coins[i]);
        int nt=check(coins,dp,i+1,amount);
        return dp[i][amount]=take+nt;
    }
}
