class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double []>pq=new PriorityQueue<>((a,b)->Double.compare(a[0],b[0]));
        for(int i=0;i<points.length;i++)
        {
            int [] pair=points[i];
            int x=pair[0],y=pair[1];
            double ans= (x*x) + (y*y);
            pq.add(new double[]{ans, x,y});
        }
        for (double [] l:pq)
        {
            System.out.println(l[0]+" "+l[1]+" "+l[2]);
        }
        int list [][]=new int[k][2];
        for(int i=0;i<k;i++)
        {
            double []a=pq.poll();
            list[i][0]=(int)a[1];
            list[i][1]=(int)a[2];
        }
        return list;

    }
}
