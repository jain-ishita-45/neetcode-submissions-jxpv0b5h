class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        pq.add(stones[i]);
        while(!pq.isEmpty())
        {
            if(pq.size()==1) return pq.peek();
            int x=pq.poll();
            int y=pq.poll();
            if((x-y)>0)
            pq.add(x-y);
        }     
        if(pq.isEmpty()) return 0;   
        return pq.peek();
    }
}
