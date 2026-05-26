public class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0],cursum=0;
        for(int num:nums)
        {
            cursum+=num;
            maxsum=Math.max(cursum,maxsum);
            if(cursum<0) cursum=0;
        }
        return maxsum;
    }
}