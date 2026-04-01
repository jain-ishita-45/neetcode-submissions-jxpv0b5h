class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        if(nums.length==0)
        return 0;
        for(int i:nums)
        set.add(i);
        int c=1, max=1;
        for(int i:set)
        {
            if(set.contains(i-1)) continue;
            else
            {
                int x=i;
                while(set.contains(x+1))
                {
                    c++;
                    x+=1;
                }
                max=Math.max(c,max);
                c=1;
            }
        }
        return max;
    }
}
