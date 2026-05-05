class Solution {
    List<List<String>> res=new ArrayList<>();
    List<String> part=new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0,0,s);
        return res;
        
    }

    public void dfs(int i, int j, String s)
    {
        if(j>=s.length())
        {
            if(i==j)
            res.add(new ArrayList<>(part));
            return;
        }
        if(palindrome(s,i,j))
        {
            part.add(s.substring(i,j+1));
            dfs(j+1,j+1,s);
            part.remove(part.size()-1);
        }
        dfs(i,j+1,s);
    }

    boolean palindrome(String s, int l, int r)
    {
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
}
