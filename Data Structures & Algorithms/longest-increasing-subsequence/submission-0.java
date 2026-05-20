class Solution {
    int []memo;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        memo=new int[n];
        Arrays.fill(memo,-1);
        int maxlis=1;
        for(int i=0;i<n;i++)
        maxlis=Math.max(maxlis,dfs(nums,i));
        return maxlis;
    }

    private int dfs(int []nums, int i)
    {
        if(memo[i]!=-1)
        return memo[i];
        int lis=1;
        for(int j=i+1;j<nums.length;j++)
        {
            if(nums[i]<nums[j])
            lis=Math.max(lis, 1+dfs(nums,j));
        }
        memo[i]=lis;
        return lis;
    }
}
