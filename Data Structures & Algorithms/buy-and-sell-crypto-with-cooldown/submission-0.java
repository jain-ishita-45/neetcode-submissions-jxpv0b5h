class Solution {

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];

        for (int[] r : dp)
            Arrays.fill(r, -1);

        return check(0, 1, prices, dp);
    }

    public int check(int i, int buy, int[] prices, int[][] dp) {

        if (i >= prices.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit = 0;

        if (buy == 1) {

            // Buy or skip
            profit = Math.max(
                    check(i + 1, 0, prices, dp) - prices[i],
                    check(i + 1, 1, prices, dp)
            );

        } else {

            // Sell or hold
            profit = Math.max(
                    check(i + 2, 1, prices, dp) + prices[i],
                    check(i + 1, 0, prices, dp)
            );
        }

        return dp[i][buy] = profit;
    }
}