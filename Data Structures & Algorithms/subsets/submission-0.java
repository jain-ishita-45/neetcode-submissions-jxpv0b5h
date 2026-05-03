class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        subset(nums,0,ans,result);
        return result;
    }

    public void subset(int []nums, int i,List<Integer> ans, List<List<Integer>> result)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        subset(nums,i+1,ans,result);
        ans.remove(ans.size()-1);
        subset(nums,i+1,ans,result);
    }
}
