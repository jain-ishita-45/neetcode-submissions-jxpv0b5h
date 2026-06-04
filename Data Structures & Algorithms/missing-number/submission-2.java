class Solution {
    public int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i]!=i)
        //     return i;
        // }
        // return nums.length;
        int n=nums.length;
        int xor=n;
        for(int i=0;i<nums.length;i++)
        {
            xor^=i^nums[i];
        }
        return xor;
    }
}
