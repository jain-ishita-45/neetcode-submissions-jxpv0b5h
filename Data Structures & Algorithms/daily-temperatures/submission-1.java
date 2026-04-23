class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<int []> st=new Stack<>();
       int result[]=new int[temperatures.length];
       for(int i=temperatures.length-1;i>=0;i--) 
       {
        while(!st.isEmpty() && st.peek()[0]<=temperatures[i])
        st.pop();
        if(st.isEmpty())
        result[i]=0;
        else
        {
            result[i]=st.peek()[1]-i;
        }
        
        st.push(new int []{temperatures[i],i});
       }
       return result;
    }
}
