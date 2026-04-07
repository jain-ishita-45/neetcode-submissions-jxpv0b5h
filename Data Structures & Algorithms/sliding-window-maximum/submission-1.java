class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int r=-1, l=0, n=nums.length,j=0;
        int list[]=new int[nums.length-k+1];
        for(int i=0;i<n;i++)
        {
          pq.offer(new int []{nums[i],i});
          if(i>=k-1)
          {
            while(pq.peek()[1]<=i-k)
            pq.poll();
            list[j++]=pq.peek()[0];
          }
        }
        return list;
    }
}
