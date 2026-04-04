class Solution {
    public int maxProfit(int[] prices) {
    //     int l=prices[0],r=prices[1],max=0;
    //    while( r<prices.length)
    //    {
        
    //     if(prices[l]<prices[r])
    //     {
    //         int profit=prices[r]-prices[l];
    //         max=Math.max(profit,max);
    //         System.out.print(max);
    //         r++;
    //     }
    //     else
    //     {
    //          l++;
    //          r++;
    //     }
       
    //    }
    //    return max;
    int cost=0, min=prices[0],profit=0;
    for(int i=1;i<prices.length;i++)
    {
        cost=prices[i]-min;
        profit=Math.max(profit,cost);
        min=Math.min(min,prices[i]);
    }
    return profit;
    }
}
