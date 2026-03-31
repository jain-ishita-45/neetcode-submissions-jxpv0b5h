class Solution {
    public int[] productExceptSelf(int[] nums) {
     int product =1;
     int newpro=1;
     int c=0;
     for(int i=0;i<nums.length;i++)
     {
        if(nums[i]==0)
        c++;
        product*=nums[i];
        if(c<=1 && nums[i]!=0) newpro*=nums[i];
     }   

     int ans []=new int[nums.length];
     if(c==nums.length) return ans;
     for(int i=0;i<nums.length;i++)
     {
        if(nums[i]==0 && c==1)
        ans[i]=newpro;
        else if(nums[i]!=0)
        ans[i]=product/nums[i];
     }
     return ans;
    }
}  
