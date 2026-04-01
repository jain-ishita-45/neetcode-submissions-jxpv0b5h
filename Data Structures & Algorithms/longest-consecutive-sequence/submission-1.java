class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);

        }
        if(nums.length==0) return 0;
        List<Integer> ans=new ArrayList<>(set);
        Collections.sort(ans);
        for(int i:ans)
        System.out.print(i+" ");
        int prev=-3,cur=-1;
        int c=1,maxc=1;
        for(int i:ans)
        {
            cur=i;
            if(cur==prev+1)
            c++;
            else
            {
                maxc=Math.max(c,maxc);
                c=1;
            }
            prev=cur;
        }
           maxc=Math.max(c,maxc);
        return maxc;
    }
}
