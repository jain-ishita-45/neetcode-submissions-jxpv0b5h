class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();

        
    }
    
    public void addNum(int num) {
        if(pq1.isEmpty() || pq1.peek()>num)
        pq1.offer(num);
        else
        pq2.offer(num);
        if(pq1.size()-pq2.size()>1)
        {
            pq2.offer(pq1.poll());
        }
        if(pq2.size()-pq1.size()>=1)
        {
            pq1.offer(pq2.poll());
        }

        
    }
    
    public double findMedian() {
        if(pq1.size()==pq2.size())
        return (double)(pq1.peek()+pq2.peek())/2.0;
        else
        return (double) pq1.peek();
    }
}
