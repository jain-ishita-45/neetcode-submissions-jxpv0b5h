class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        comb(0,0,ans,result, target, nums);
        return result;
    }

    public void comb(int i, int sum, List<Integer> ans, List<List<Integer>> result, int target, int nums[] )
    {
        if(sum>target) return;
        if(sum==target)
        {
            result.add(new ArrayList<>(ans));
            return;
        }
        if(i==nums.length) return;
        ans.add(nums[i]);
        comb(i,sum+nums[i],ans,result, target,nums);
         ans.remove(ans.size()-1);
        comb(i+1,sum,ans,result, target,nums);
    }
}
