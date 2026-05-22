class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int n : nums)
            total += n;

        int[][] dp = new int[nums.length][2 * total + 1];

        for (int[] r : dp)
            Arrays.fill(r, Integer.MIN_VALUE);

        return check(0, nums, target, 0, dp, total);
    }

    public int check(int i, int[] nums, int target,
                     int sum, int[][] dp, int offset) {

        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + offset] != Integer.MIN_VALUE)
            return dp[i][sum + offset];

        int plus = check(i + 1, nums, target,
                         sum + nums[i], dp, offset);

        int minus = check(i + 1, nums, target,
                          sum - nums[i], dp, offset);

        return dp[i][sum + offset] = plus + minus;
    }
}