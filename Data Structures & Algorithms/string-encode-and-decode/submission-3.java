class Solution {

    public String encode(List<String> strs) {
        StringBuilder st=new StringBuilder();
        for(String s:strs)
        {
            st.append("("+s+")");
        }
        System.out.print(st.toString());
        decode(st.toString());
        return st.toString();

    }

    public List<String> decode(String str) {
        List<String> s=new ArrayList<>();
        String cur="";
        int c=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(' && c==0)
            {
                c++;
                continue;
            }
            
            
            else if(str.charAt(i)==')' && c==1)
            {
                s.add(cur);
                cur="";
                c--;
                continue;
            }
          
             cur+=str.charAt(i);
             if(str.charAt(i)=='(') c++;
             if(str.charAt(i)==')') c--;
        
           
        }
        return s;

    }
}
