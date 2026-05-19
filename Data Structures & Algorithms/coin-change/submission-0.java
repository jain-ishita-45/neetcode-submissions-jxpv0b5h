class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][]dp=new int [coins.length][amount+1];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        int res=check(dp,coins,amount,0);
        
        if(res>=100000) return -1;
        return res;
    }

    public int check(int [][]dp, int []coins, int amount, int i)
    {
        if(amount==0) return 0;
        if(coins.length<=i) return 100000;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int left=100000,right=100000;
        if(amount>=coins[i])
        {
            left=check(dp,coins,amount-coins[i],i)+1;
        }
        right=check(dp,coins,amount,i+1);
        return dp[i][amount]=Math.min(left,right);
    }
}
