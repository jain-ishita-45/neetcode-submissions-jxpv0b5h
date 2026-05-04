class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        subset(0,nums,result,ans);
        return result;
    }

    public void subset(int i, int[]nums, List<List<Integer>> result, List<Integer>ans)
    {
        if(i==nums.length)
        {
            if(!result.contains(ans))
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        subset(i+1,nums,result,ans);
        ans.remove(ans.size()-1);
        subset(i+1,nums,result,ans);
    }
}
