class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
        HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<nums.length;i++)
      {
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      }  
      for(Map.Entry<Integer,Integer> e:map.entrySet())
      {
        int v1=e.getKey();
        int v2=e.getValue();
        pq.offer(new int[]{v1,v2});
      }
      int ans[]=new int[k];
      int k1=0;
      while(k!=0)
      {
        int []a=pq.poll();
        ans[k1++]=a[0];
        k--;
      }
      return ans;
    }
}
