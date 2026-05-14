class Solution {

    public int count(int dp[],int i, int []nums)
    {
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int nt=count(dp,i-1,nums);
        int take=count(dp,i-2,nums)+nums[i];
        return dp[i]=Math.max(nt,take);
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp1[]=new int[nums.length];
        Arrays.fill(dp1,-1);
        int case1=count(dp1,nums.length-2,nums);

        int dp2[]=new int[nums.length];
        Arrays.fill(dp2,-1);
        int nums2[]=Arrays.copyOfRange(nums,1,nums.length);
        int case2=count(dp2,nums.length-2,nums2);
        return Math.max(case1,case2);

    }
}
