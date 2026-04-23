class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxarea=0;
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                int element=st.pop();
                int nse=i;
                int pse=0;
                if(st.isEmpty())
                pse=-1;
                else
                pse=st.peek();
                System.out.println(heights[element]+" "+nse+" "+pse);
                maxarea=Math.max(maxarea, heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
         System.out.println(st.peek()+" ");
         while(!st.isEmpty() )
            {
                int element=st.pop();
                int nse=heights.length;
                int pse=0;
                if(st.isEmpty())
                pse=-1;
                else
                pse=st.peek();
                 System.out.println(heights[element]+" "+nse+" "+pse);
                maxarea=Math.max(maxarea, heights[element]*(nse-pse-1));
            }
            return maxarea;
           
    }
}
