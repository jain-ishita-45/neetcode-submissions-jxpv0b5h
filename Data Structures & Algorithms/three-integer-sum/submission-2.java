class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            int l=i+1,r=nums.length-1;
            while(l<r)
            {
                if(nums [i]+nums[l]+nums[r]==0)
                {
                    List<Integer> l1=new ArrayList<>();
                    Collections.addAll(l1,nums[i],nums[l],nums[r]);
                    if(! list.contains(l1))
                    list.add(l1);
                    l++;
                    r--;
                }
                else if((nums [i]+nums[l]+nums[r])>0)
                r--;
                else
                l++;
            }
        }
        return list;
    }
}
