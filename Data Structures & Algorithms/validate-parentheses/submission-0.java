class Solution {

  public boolean isMatch(char a, char b)
  {
    if((a=='[' && b==']') || (a=='{' && b=='}') || (a=='(' && b==')'))
    return true;
    return false;
  }
    public boolean isValid(String s) {
     Stack<Character> st=new Stack<>();
     for(int i=0;i<s.length();i++)
     {
      char ch=s.charAt(i);
      if(ch=='[' || ch=='(' || ch=='{')
      st.push(ch);
      else if(ch==']' || ch==')' || ch=='}')
      {
        if(st.isEmpty()) return false;
        char ch2=st.pop();
        if(!isMatch(ch2,ch))
        return false;
      }
     }   
     if (st.isEmpty()) return true;
     return false;
    }
}
