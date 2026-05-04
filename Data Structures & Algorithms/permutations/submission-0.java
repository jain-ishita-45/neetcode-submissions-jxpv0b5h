class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean []freq=new boolean[nums.length];
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        comb(nums,freq,result,ans);
        return result;
        
    }

    public void comb(int []nums, boolean[] freq,List<List<Integer>> result,List<Integer> ans)
    {
        if(nums.length==ans.size())
        {
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(freq[i]==false)
            {freq[i]=true;
            ans.add(nums[i]);
            comb(nums,freq,result,ans);
            ans.remove(ans.size()-1);
            freq[i]=false;
            }
        }
    }
}
