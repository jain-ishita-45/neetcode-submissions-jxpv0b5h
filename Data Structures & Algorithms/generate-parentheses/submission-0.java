class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generate(0,0,"",result,n);
        return result;
    }

    public void generate(int open, int close, String ans,List<String> result,int n)
    {
        if(2*n==ans.length())
        {
            result.add(new String(ans));
            return;
        }
        if(open<n)
        generate(open+1,close,ans+"(",result,n);
        if(close<open)
        {
             generate(open,close+1,ans+")",result,n);
        }
    }
}
