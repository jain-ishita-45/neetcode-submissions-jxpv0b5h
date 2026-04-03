class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int rem=-nums[i]-nums[j];
                if(set.contains(rem))
                {
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(rem);
                    
                    if(!list.contains(l))
                    list.add(l);
                }
                
            }
            set.add(nums[i]);
        }
        return list;
    }
}
