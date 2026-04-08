class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        char []t=new char[tokens.length];
        
        for(String c:tokens)
        {
            
            
               
            if(c.equals("+") ||c.equals("-") || c.equals("*") ||c.equals("/"))
            {
                int ch1=st.pop();
                int ch2=st.pop();
                System.out.print(ch2+" "+ch1);
                char op=c.charAt(0);
                int ans=0;
                if (op=='+')
                ans=ch1+ch2;
                else if(op=='-')
                ans=ch2-ch1;
                else if(op=='*')
                ans=ch2*ch1;
                else
                ans=ch2/ch1;
                st.push(ans);
            }
            else
             st.push(Integer.parseInt(c));

        }
        return st.peek();
    }
}
