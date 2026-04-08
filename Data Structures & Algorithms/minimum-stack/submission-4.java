class MinStack {
    Stack<Integer> st;
    Stack<Integer> minstack;


    public MinStack() {
        st=new Stack<>();
        minstack=new Stack<>();
        
    }
    
    public void push(int val) {
        
        st.push(val);

        if(!minstack.isEmpty() && minstack.peek()>=val)
        minstack.push(val);
        if(minstack.isEmpty())
        minstack.push(val);
        
    }
    
    public void pop() {
        int x1=0;
        if(st.isEmpty())
        return;
        x1=st.pop();
        if(!minstack.isEmpty() && minstack.peek()==x1)
        minstack.pop();
        
    }
    
    public int top() {
        if(st.isEmpty())
        return 0;
        return st.peek();
        
    }
    
    public int getMin() {
        if(minstack.isEmpty())
        return 0;
        return minstack.peek();
        
    }
}
