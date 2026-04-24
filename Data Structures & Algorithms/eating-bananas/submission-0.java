class Solution {
    public int func(int [] piles, int h)
    {
        int tt=0;
        for(int i:piles)
        {
            tt+=(i+h-1)/h;
        }
        return tt;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=0,ans=1;
        for(int i:piles)
        max=Math.max(i,max);
        int low=1, high=max;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(func(piles,mid)<=h)
            {
                ans=mid;
                high=mid-1;

            }
            else
            low=mid+1;
        }
        return ans;
    }
}
